package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Advertisement;
import bada_project.SpringApplication.model.Guest;
import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AdvertisementDAO implements DAO<Advertisement> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdvertisementDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Return one Track object with specified nr_nagrania.
     * @param nr_nagrania
     * @return Track object
     */
    @Override
    public Advertisement get(int nr_nagrania) {
        String sql = "SELECT * FROM REKLAMY WHERE NR_NAGRANIA=" + nr_nagrania;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Advertisement.class));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Advertisement> getAll() {
        String sql = "SELECT * FROM REKLAMY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Advertisement.class));
    }

    public List<Advertisement> getAdsAddedToBroadcast(int nr_audycji) {
        String sql = "SELECT REKLAMY.* FROM REKLAMY LEFT JOIN NAGRANIA ON NAGRANIA.nr_nagrania = REKLAMY.nr_nagrania WHERE REKLAMY.NR_NAGRANIA IN (SELECT NAGRANIE_AUDYCJA.NR_NAGRANIA FROM NAGRANIE_AUDYCJA WHERE NR_AUDYCJI=?)";;
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Advertisement.class),nr_audycji);
    }


    /**
     * Add new or update record to table. Auto set unique key value.
     * @param ad
     */
    @Override
    public void saveOrUpdate(Advertisement ad) {

        if(ad.getNr_nagrania()>0){
            // update
            String sql = "UPDATE REKLAMY SET TRANSKRYPT=?, DATA_OD=?, DATA_DO=?, CENA=?, ODTWORZENIA=?, NR_REKLAMODAWCY=? WHERE NR_NAGRANIA=?";
            jdbcTemplate.update(sql,ad.getTranskrypt(),ad.getData_od(),ad.getData_do(),ad.getCena(),ad.getOdtworzenia(),ad.getNr_reklamodawcy(), ad.getNr_nagrania());
        }else{
            // insert
            String sql = "INSERT INTO REKLAMY (TRANSKRYPT, DATA_OD, DATA_DO, CENA, ODTWORZENIA, NR_REKLAMODAWCY) VALUES(?,?,?,?,?,?); ";
            jdbcTemplate.update(sql,ad.getTranskrypt(),ad.getData_od(),ad.getData_do(),ad.getCena(),ad.getOdtworzenia(),ad.getNr_reklamodawcy());
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
