package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Audycja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AudycjaDAO implements DAO<Audycja> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AudycjaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Return one Audycja object with specified id.
     * @param id
     * @return Audycja object
     */
    @Override
    public Audycja get(int id) {
        String sql = "SELECT * FROM audycje WHERE nr_audycji=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Audycja.class));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Audycja> getAll() {
        String sql = "SELECT * FROM AUDYCJE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Audycja.class));
    }

    /**
     * Add new or update record to table. Auto set unique key value.
     * @param audycja
     */
    @Override
    public void saveOrUpdate(Audycja audycja) {
        // update
        if(audycja.getNr_audycji()>0){
            String sql = "UPDATE AUDYCJE SET DATA=?, FORMAT=?, CZAS_TRWANIA=?, NR_ROZGLOSNI=? WHERE NR_AUDYCJI=?";
            jdbcTemplate.update(sql,audycja.getData(),audycja.getFormat(),audycja.getCzas_trwania(), audycja.getNr_rozglosni(),audycja.getNr_audycji());
        }else{
            // insert
            String sql = "INSERT INTO audycje (DATA, FORMAT, CZAS_TRWANIA, NR_ROZGLOSNI) VALUES(?,?,?,?)";
            jdbcTemplate.update(sql,audycja.getData(),audycja.getFormat(),audycja.getCzas_trwania(),audycja.getNr_rozglosni());
        }
    }

    /**
     * Delete from database
     * @param id
     */
    @Override
    public void delete(int  id) {
        String sql = "DELETE FROM audycje WHERE nr_audycji=?";
        jdbcTemplate.update(sql, id);
    }


}
