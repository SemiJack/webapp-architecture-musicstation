package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Audycja;
import bada_project.SpringApplication.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AutorDAO implements DAO<Autor> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AutorDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Return one Autor object with specified id.
     * @param id
     * @return Autor object
     */
    @Override
    public Autor get(int id) {
        String sql = "SELECT * FROM AUTORZY WHERE NR_AUTORA=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Autor.class));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Autor> getAll() {
        String sql = "SELECT * FROM AUTORZY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Autor.class));
    }

    /**
     * Add new or update record to table. Auto set unique key value.
     * @param autor
     */
    @Override
    public void saveOrUpdate(Autor autor) {
        // update
        if(autor.getNr_autora()>0){
            String sql = "UPDATE AUTORZY SET NAZWA=?, DEBIUT=?, WYTWORNIA=?, LICZBA_CZLONKOW=?, NR_ROZGLOSNI=? WHERE NR_AUTORA=?";
            jdbcTemplate.update(sql,autor.getNazwa(),autor.getDebiut(),autor.getWytwornia(), autor.getLiczba_czlonkow(),autor.getNr_rozglosni(), autor.getNr_autora());
        }else{
            // insert
            String sql = "INSERT INTO AUTORZY (NAZWA, DEBIUT, WYTWORNIA, LICZBA_CZLONKOW, NR_ROZGLOSNI) VALUES(?,?,?,?,?)";
            jdbcTemplate.update(sql,autor.getNazwa(),autor.getDebiut(),autor.getWytwornia(), autor.getLiczba_czlonkow(),autor.getNr_rozglosni());
        }
    }

    /**
     * Delete from database
     * @param id
     */
    @Override
    public void delete(int  id) {
        String sql = "DELETE FROM AUTORZY WHERE NR_AUTORA=?";
        jdbcTemplate.update(sql, id);
    }


}
