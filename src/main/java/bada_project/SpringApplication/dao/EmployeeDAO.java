package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;


@Repository
public class EmployeeDAO implements DAO<Employee> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Employee get(int nr_pracownika) {
        String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika=" + nr_pracownika;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    public Employee getByName(String user) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LinkedList<String> result = new LinkedList<>();
        for (String w : name.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
            result.add(w);
        }
        String sql = "SELECT * FROM PRACOWNICY WHERE IMIE = ? AND NAZWISKO = ? ";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), result.get(0), result.get(1));
    }


    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM PRACOWNICY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }


    @Override
    public void saveOrUpdate(Employee employee) {
        if (employee.getNr_pracownika() > 0) {
            // update
            String sql = "UPDATE PRACOWNICY SET IMIE=?, NAZWISKO=?, DATA_URODZENIA=?, PESEL=?, PLEC=?,DATA_ZATRUDNIENIA=?, NR_KONTA=?,EMAIL=?,NR_TELEFONU=?, NR_ROZGLOSNI=?,NR_ADRESU=?,NR_STANOWISKA=? WHERE NR_PRACOWNIKA=?";
            jdbcTemplate.update(sql, employee.getImie(), employee.getNazwisko(), employee.getData_urodzenia(), employee.getPesel(), employee.getPlec(), employee.getData_zatrudnienia(), employee.getNr_konta(), employee.getEmail(), employee.getNr_telefonu(), employee.getNr_rozglosni(), employee.getNr_adresu(), employee.getNr_stanowiska(), employee.getNr_pracownika());
        } else {
            // insert
            String sql = "INSERT INTO PRACOWNICY (IMIE, NAZWISKO, DATA_URODZENIA, PESEL, PLEC, DATA_ZATRUDNIENIA, NR_KONTA,EMAIL,NR_TELEFONU, NR_ROZGLOSNI,NR_ADRESU,NR_STANOWISKA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, employee.getImie(), employee.getNazwisko(), employee.getData_urodzenia(), employee.getPesel(), employee.getPlec(), employee.getData_zatrudnienia(), employee.getNr_konta(), employee.getEmail(), employee.getNr_telefonu(), employee.getNr_rozglosni(), employee.getNr_adresu(), employee.getNr_stanowiska());
        }
    }


    @Override
    public void delete(int nr_pracownika) {
        try {
            String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika=?";
            jdbcTemplate.update(sql, nr_pracownika);
        } catch (DataIntegrityViolationException e) {
            System.out.println("dsdasdas");
        }
    }


}
