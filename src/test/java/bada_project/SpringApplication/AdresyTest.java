package bada_project.SpringApplication;

import bada_project.SpringApplication.dao.AudycjaDAO;
import bada_project.SpringApplication.model.Adres;
import bada_project.SpringApplication.dao.AdresDAO;
import bada_project.SpringApplication.model.Audycja;
import bada_project.SpringApplication.model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ATTENTION!! Tricky it is ;) Before testing insert proper values according to actual database state.
 * Indexes always increase. Example: even if you delete record with id 25 next id will be 26.
 */
class AdresyTest {
    private AudycjaDAO audycjaDAO;
    @BeforeEach
    void setup() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BADAGRB01");
        dataSource.setPassword("BADAGRB01");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        audycjaDAO = new AudycjaDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testGetAll(){
        List<Audycja> listAudycja = audycjaDAO.getAll();
        assertFalse(listAudycja.isEmpty());
    }

//    @Test
//    void testSaveOrUpdate() {
//        Adres adres = new Adres("Łódź", "Rurkowa", "3B");
//        adresDao.saveOrUpdate(adres);
//    }
//
//    @Test
//    void testGet(){
//        adresDao.get(26);
//    }
//
//
//    @Test
//    void testDelete(){
//        adresDao.delete(26);
//    }


}
