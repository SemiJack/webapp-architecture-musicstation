package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RecordingDAO implements DAO<Recording> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RecordingDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long saveOrUpdateID(Recording recording) {
        if (recording.getNr_nagrania() > 0) {
            // update
            String sql = "UPDATE NAGRANIA SET CZAS_TRWANIA=?, TYTUL=?, NR_ROZGLOSNI=? WHERE NR_NAGRANIA=?";
            jdbcTemplate.update(sql, recording.getCzas_trwania(), recording.getTytul(), recording.getNr_rozglosni());
        } else {
            //insert
            String insertSql = "INSERT INTO NAGRANIA (CZAS_TRWANIA, TYTUL, NR_ROZGLOSNI)" + " VALUES(?,?,?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"nr_nagrania"});
                ps.setString(1, recording.getCzas_trwania());
                ps.setString(2, recording.getTytul());
                ps.setInt(3, recording.getNr_rozglosni());
                return ps;
            }, keyHolder);
            return keyHolder.getKey().longValue();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Recording recording) {
        saveOrUpdateID(recording);
    }


    @Override
    public Recording get(int nr_nagrania) {
        String sql = "SELECT * FROM NAGRANIA WHERE NR_NAGRANIA=" + nr_nagrania;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Recording.class));
    }


    @Override
    public List<Recording> getAll() {
        String sql = "SELECT * FROM NAGRANIA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Recording.class));
    }

    public void bindWithBroadcast(int id_recording, int id_broadcast) {
        String sql = "INSERT INTO Nagranie_Audycja (NR_NAGRANIA, NR_AUDYCJI) VALUES(?,?)";
        jdbcTemplate.update(sql, id_recording, id_broadcast);
    }

    public void unbindWithBroadcast(int id_recording, int id_broadcast) {
        String sql = "DELETE FROM Nagranie_Audycja WHERE NR_NAGRANIA=? AND NR_AUDYCJI=?";
        jdbcTemplate.update(sql, id_recording, id_broadcast);
    }


    @Override
    public void delete(int nr_nagrania) {
        String sql = "DELETE FROM NAGRANIA WHERE nr_nagrania=?";
        jdbcTemplate.update(sql, nr_nagrania);
    }
}
