package bada_project.SpringApplication.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T get(int id);

    List<T> getAll();

    void saveOrUpdate(T t);

    void delete(int id);
}
