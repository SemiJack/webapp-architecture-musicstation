package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Guest;
import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GuestDAO implements DAO<Guest> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Return one Track object with specified nr_nagrania.
     * @param nr_goscia
     * @return Track object
     */
    @Override
    public Guest get(int nr_goscia) {
        String sql = "SELECT * FROM GOSCIE WHERE nr_goscia=" + nr_goscia;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Guest.class));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Guest> getAll() {
        String sql = "SELECT * FROM GOSCIE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Guest.class));
    }

    public List<Guest> getGuestsAddedToBroadcast(int nr_goscia) {
        String sql = "SELECT * FROM GOSCIE WHERE GOSCIE.NR_GOSCIA IN (SELECT GOSCIE_AUDYCJE.NR_GOSCIA FROM GOSCIE_AUDYCJE WHERE NR_AUDYCJI=?)";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Guest.class),nr_goscia);
    }

    public void bindWithBroadcast(int nr_goscia, int nr_audycji){
        String sql = "INSERT INTO GOSCIE_AUDYCJE (NR_GOSCIA, NR_AUDYCJI) VALUES(?,?)";
        jdbcTemplate.update(sql, nr_goscia, nr_audycji);
    }
    public void unbindWithBroadcast(int nr_goscia, int nr_audycji){
        String sql = "DELETE FROM GOSCIE_AUDYCJE WHERE NR_GOSCIA=? AND NR_AUDYCJI=?";
        jdbcTemplate.update(sql, nr_goscia, nr_audycji);
    }


    /**
     * Add new or update record to table. Auto set unique key value.
     * @param guest
     */
    @Override
    public void saveOrUpdate(Guest guest) {

        if(guest.getNr_goscia()>0){
            // update
            String sql = "UPDATE GOSCIE SET imie=?, nazwisko=?, pseudonim=?, email=?, nr_telefonu=?, nr_rozglosni=? WHERE nr_goscia=?";
            jdbcTemplate.update(sql,guest.getImie(),guest.getNazwisko(), guest.getPseudonim(),guest.getEmail(),guest.getNr_telefonu(),guest.getNr_rozglosni(), guest.getNr_goscia());
        }else{
            // insert
            String sql = "INSERT INTO GOSCIE (IMIE, NAZWISKO, PSEUDONIM, EMAIL, NR_TELEFONU, NR_ROZGLOSNI) VALUES(?,?,?,?,?,?); ";
            jdbcTemplate.update(sql, guest.getImie(),guest.getNazwisko(), guest.getPseudonim(),guest.getEmail(),guest.getNr_telefonu(),guest.getNr_rozglosni());
        }
    }

    /**
     * Delete from database
     * @param nr_goscia
     */
    @Override
    public void delete(int  nr_goscia) {
        String sql = "DELETE FROM GOSCIE WHERE nr_goscia=?";
        jdbcTemplate.update(sql, nr_goscia);
    }
}
