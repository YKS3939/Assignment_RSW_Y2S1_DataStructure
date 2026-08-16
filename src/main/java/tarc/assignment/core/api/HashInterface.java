package tarc.assignment.core.api;

public interface HashInterface <K,V>{
    void add(K key, V value);
    V get(K key);
    void remove(K key);
    boolean exist(K key);
    void clear();
}
