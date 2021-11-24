package by.itacademy.javaenterprise.kotkovski.dao;

public interface CrudRepository<K, E> {
    E save(E entity);
    E findById(K id);
}
