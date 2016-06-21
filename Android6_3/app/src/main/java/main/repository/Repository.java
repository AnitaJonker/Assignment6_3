package main.repository;

import java.util.Set;

/**
 * Created by Anita on 2016/04/22.
 */
public interface Repository<E, ID> {

    E findById(long id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}