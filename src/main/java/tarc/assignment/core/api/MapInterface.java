package tarc.assignment.core.api;

/**
 * Goh Wen Ting
 * @param <K>
 * @param <V>
 */
public interface MapInterface<K,V>{
    void add(K key, V value);
    V get(K key);
    void remove(K key);
    boolean exist(K key);
    void clear();
}
