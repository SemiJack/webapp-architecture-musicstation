package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AdresDAO implements DAO<Adres> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Adres get(int nr_adresu) {
        String sql = "SELECT * FROM adresy WHERE nr_adresu=" + nr_adresu;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    @Override
    public List<Adres> getAll() {
        String sql = "SELECT * FROM Adresy";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    /**
     * Add new or update record to table. Auto set unique key value.
     *
     * @param adres
     */
    @Override
    public void saveOrUpdate(Adres adres) {
        // update
        if(adres.getNr_adresu()>0){
            String sql = "UPDATE adresy SET miasto=?, ulica=?, nr_lokalu=? WHERE nr_adresu=?";
            jdbcTemplate.update(sql,adres.getMiasto(),adres.getUlica(),adres.getNr_lokalu(),adres.getNr_adresu());
        }else{
            // insert
            String sql = "INSERT INTO adresy (miasto, ulica, nr_lokalu) VALUES(?,?,?)";
            jdbcTemplate.update(sql,adres.getMiasto(),adres.getUlica(),adres.getNr_lokalu());
        }
//        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
//        insertActor.withTableName("Adresy").usingColumns("miasto", "ulica", "nr_lokalu");
//        insertActor.usingGeneratedKeyColumns("nr_adresu");
//        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
//        Number key = insertActor.executeAndReturnKey(param);
//        adres.setNr_adresu(key.intValue());
    }

    @Override
    public void delete(int  nr_adresu) {
        String sql = "DELETE FROM adresy WHERE nr_adresu=?";
        jdbcTemplate.update(sql, nr_adresu);
    }


}
