package bada_project.SpringApplication.dao;

import bada_project.SpringApplication.model.Address;
import bada_project.SpringApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Return one Employee object with specified nr_pracownika.
     * @param nr_pracownika
     * @return Employee object
     */
    @Override
    public Employee get(int nr_pracownika) {
        String sql = "SELECT * FROM PRACOWNICY WHERE nr_pracownika=" + nr_pracownika;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    public Employee getByName(String user) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        LinkedList<String> result = new LinkedList<String>();
        for (String w : name.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
            result.add(w);
        }
        String sql = "SELECT * FROM PRACOWNICY WHERE IMIE = ? AND NAZWISKO = ? ";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), result.get(0), result.get(1));
    }

    /**
     * Get all records from table
     * @return list of all records
     */
    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM PRACOWNICY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    /**
     * Add new or update record to table. Auto set unique key value.
     * @param employee
     */
    @Override
    public void saveOrUpdate(Employee employee) {
        if(employee.getNr_pracownika()>0){
            // update
            String sql = "UPDATE PRACOWNICY SET imie=?, nazwisko=?, data_urodzenia=?, pesel=? WHERE nr_pracownika=?";
            jdbcTemplate.update(sql, employee.getImie(), employee.getNazwisko(), employee.getData_urodzenia(), employee.getPesel());
        }else{
            // insert
            String sql = "INSERT INTO PRACOWNICY (imie, nazwisko, data_urodzenia, pesel) VALUES(?,?,?)";
            jdbcTemplate.update(sql, employee.getImie(), employee.getNazwisko(), employee.getData_urodzenia(), employee.getPesel());
        }
    }


    /**
     * Delete from database
     * @param nr_pracownika
     */
    @Override
    public void delete(int  nr_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika=?";
        jdbcTemplate.update(sql, nr_pracownika);
    }


}
