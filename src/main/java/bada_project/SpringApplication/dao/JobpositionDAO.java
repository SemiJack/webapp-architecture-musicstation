package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Jobposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JobpositionDAO implements DAO<Jobposition> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobpositionDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Jobposition get(int nr_stanowiska) {
        String sql = "SELECT * FROM STANOWISKO WHERE NR_STANOWISKA=" + nr_stanowiska;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Jobposition.class));
    }

    @Override
    public List<Jobposition> getAll() {
        String sql = "SELECT * FROM STANOWISKO";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Jobposition.class));
    }

    @Override
    public void saveOrUpdate(Jobposition jobposition) {

        if (jobposition.getNr_stanowiska() > 0) {
            // update
            String sql = "UPDATE STANOWISKO SET NAZWA=?, OPIS=? WHERE NR_STANOWISKA=?";
            jdbcTemplate.update(sql, jobposition.getNazwa(), jobposition.getOpis(), jobposition.getNr_stanowiska());
        } else {
            // insert
            String sql = "INSERT INTO STANOWISKO (NAZWA, OPIS) VALUES(?,?,?)";
            jdbcTemplate.update(sql, jobposition.getNazwa(), jobposition.getOpis());
        }
    }

    @Override
    public void delete(int nr_stanowiska) {
        String sql = "DELETE FROM STANOWISKO WHERE NR_STANOWISKA=?";
        jdbcTemplate.update(sql, nr_stanowiska);
    }
}
