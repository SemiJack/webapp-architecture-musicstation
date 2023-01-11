package bada_project.SpringApplication.database;

import bada_project.SpringApplication.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AdresDAO implements DAO<Adres> {
    private JdbcTemplate jdbcTemplate;
    private List<Adres> adresy = new ArrayList<>();
    @Autowired
    public AdresDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Adres>get(long nr_adresu){
        return Optional.ofNullable(adresy.get((int)nr_adresu));
    }
    @Override
    public List<Adres> getAll(){
        String sql = "SELECT * FROM Adresy";
        adresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adresy;
    }

    @Override
    public void save(Adres adres){
        adresy.add(adres);
    }

    @Override
    public void update(Adres adres, String[] params){
        adres.setNr_adresu(Integer.parseInt(params[0]));
        adres.setMiasto(params[1]);
        adres.setUlica(params[2]);
        adres.setNr_lokalu(params[3]);

        adresy.add(adres);
    }

    @Override
    public void delete(Adres adres){
        adresy.remove(adres);
    }


}
