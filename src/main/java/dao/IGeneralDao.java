package dao;

import java.util.List;

public interface IGeneralDao<T> {
    List<T> show();

    boolean create(T t);

    boolean update(int id, T t);

    boolean delete(int id);

    boolean save(T t);

    T findById(int id);
}
