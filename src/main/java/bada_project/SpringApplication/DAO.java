package bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Adres> list(){
        String sql = "SELECT * FROM Adresy";

        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdres;
    }

    public void save(Adres adres){

    }

    public Adres get(int id){
        return null;
    }

    public void update(Adres adres){

    }

    public void delete(int id){

    }
}
