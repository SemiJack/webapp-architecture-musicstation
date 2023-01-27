package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TrackDAO implements DAO<Track> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrackDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Track get(int nr_nagrania) {
        String sql = "SELECT * FROM UTWORY WHERE NR_NAGRANIA=" + nr_nagrania;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Track.class));
    }


    @Override
    public List<Track> getAll() {
        String sql = "SELECT * FROM UTWORY LEFT JOIN NAGRANIA ON NAGRANIA.nr_nagrania=UTWORY.nr_nagrania";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Track.class));
    }

    public List<Track> getTracksAddedToBroadcast(int nr_audycji) {
        String sql = "SELECT * FROM UTWORY LEFT JOIN NAGRANIA ON NAGRANIA.nr_nagrania = UTWORY.nr_nagrania WHERE UTWORY.NR_NAGRANIA IN (SELECT NAGRANIE_AUDYCJA.NR_NAGRANIA FROM NAGRANIE_AUDYCJA WHERE NR_AUDYCJI=?)";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Track.class), nr_audycji);
    }


    @Override
    public void saveOrUpdate(Track track) {

        if (track.getNr_nagrania() > 0) {
            // update
            String sql = "UPDATE UTWORY SET album=?, licencja=?, waznosc_licencji=? WHERE nr_nagrania=?";
            jdbcTemplate.update(sql, track.getAlbum(), track.getWaznosc_licencji());
        } else {
            // insert
            String sql = "INSERT INTO UTWORY (nr_nagrania, album, licencja, waznosc_licencji) VALUES(?,?,?,?); ";
            jdbcTemplate.update(sql, track.getNr_nagrania(), track.getAlbum(), track.getLicencja(), track.getWaznosc_licencji());
        }
    }


    @Override
    public void delete(int nr_nagrania) {
        String sql = "DELETE FROM UTWORY WHERE nr_nagrania=?";
        jdbcTemplate.update(sql, nr_nagrania);
    }
}
