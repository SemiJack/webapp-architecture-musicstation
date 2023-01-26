package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddressDAO implements DAO<Address> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Address get(int nr_adresu) {
        String sql = "SELECT * FROM ADRESY WHERE nr_adresu=" + nr_adresu;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Address.class));
    }

    @Override
    public List<Address> getAll() {
        String sql = "SELECT * FROM ADRESY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Address.class));
    }


    @Override
    public void saveOrUpdate(Address address) {

        if (address.getNr_adresu() > 0) {
            // update
            String sql = "UPDATE ADRESY SET miasto=?, ulica=?, nr_lokalu=? WHERE nr_adresu=?";
            jdbcTemplate.update(sql, address.getMiasto(), address.getUlica(), address.getNr_lokalu(), address.getNr_adresu());
        } else {
            // insert
            String sql = "INSERT INTO ADRESY (miasto, ulica, nr_lokalu) VALUES(?,?,?)";
            jdbcTemplate.update(sql, address.getMiasto(), address.getUlica(), address.getNr_lokalu());
        }
    }


    @Override
    public void delete(int nr_adresu) {
        String sql = "DELETE FROM ADRESY WHERE nr_adresu=? AND NOT EXISTS(SELECT * FROM PRACOWNICY p WHERE nr_adresu=?)";

        jdbcTemplate.update(sql, nr_adresu, nr_adresu);
    }


}
