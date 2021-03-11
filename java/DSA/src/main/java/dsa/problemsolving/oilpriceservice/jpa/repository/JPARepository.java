package dsa.problemsolving.oilpriceservice.jpa.repository;

import java.util.Map;

public interface JPARepository<T> {

    boolean insert(T record);

    boolean delete(T record);

    boolean update(T record);

    T fetch(Object id);

    Map<Object, T> fetchAll();
}
