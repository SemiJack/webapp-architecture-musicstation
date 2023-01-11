package bada_project.SpringApplication;

import bada_project.SpringApplication.model.Adres;
import bada_project.SpringApplication.dao.AdresDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyTest {
    private AdresDAO adresDao;
    @BeforeEach
    void setup() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BADAGRB01");
        dataSource.setPassword("BADAGRB01");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        adresDao = new AdresDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testGetAll(){
        List<Adres> listAdres = adresDao.getAll();
        assertFalse(listAdres.isEmpty());
    }

    @Test
    void testSave() {
        Adres adres = new Adres("Bydgoszcz", "Kopernika", "320");
        adresDao.saveOrUpdate(adres);
    }

}
