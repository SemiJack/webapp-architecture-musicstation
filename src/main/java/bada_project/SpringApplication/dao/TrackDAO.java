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

    /**
     * Return one Track object with specified nr_nagrania.
     * @param nr_nagrania
     * @return Track object
     */
    @Override
    public Track get(int nr_nagrania) {
        String sql = "SELECT * FROM ADRESY WHERE nr_nagrania=" + nr_nagrania;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Track.class));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Track> getAll() {
        String sql = "SELECT * FROM UTWORY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Track.class));
    }

    /**
     * Add new or update record to table. Auto set unique key value.
     * @param track
     */
    @Override
    public void saveOrUpdate(Track track) {

        if(track.getNr_nagrania()>0){
            // update
            String sql = "UPDATE UTWORY SET album=?, licencja=?, waznosc_licencji=? WHERE nr_nagrania=?";
            jdbcTemplate.update(sql, track.getAlbum(), track.getWaznosc_licencji());
        }else{
            // insert
            String sql = "INSERT INTO UTWORY (nr_nagrania, album, licencja, waznosc_licencji) VALUES(?,?,?,?); ";
            jdbcTemplate.update(sql, track.getNr_nagrania(), track.getAlbum(), track.getLicencja(), track.getWaznosc_licencji());
        }
    }

    /**
     * Delete from database
     * @param nr_nagrania
     */
    @Override
    public void delete(int  nr_nagrania) {
        String sql = "DELETE FROM UTWORY WHERE nr_nagrania=?";
        jdbcTemplate.update(sql, nr_nagrania);
    }
}