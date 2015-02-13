package org.lcm.backend.common;

/**
 * Created by abelsromero on 13/02/2015.
 */
public interface Persistable<T, K> {

    /**
    * Generated fields (e.g. id) are returned in the entity
    */
    void create (T entity);

    T findById(K id);

    void update(T entity);
    // This method can be handy in the future
    void update(K id, T entity);

    void delete(K id);

}
