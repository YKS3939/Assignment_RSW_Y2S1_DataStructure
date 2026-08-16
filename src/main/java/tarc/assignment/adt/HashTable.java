package tarc.assignment.adt;

import tarc.assignment.core.api.HashInterface;

/**
 *  Goh Wen Ting
 */
public class HashTable <K,V> implements HashInterface<K,V> {
    private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<Node>[] room = new ArrayList[DEFAULT_CAPACITY];

    public  HashTable(){
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            room[i]=new ArrayList<>(25);
        }
    }

    @Override
    public void add(K key, V value){
        int index=hashKey(key);
        for (int i = 0; i < room[index].getSize(); i++) {
            if (room[index].get(i).key.equals(key)){
                room[index].replace(i,new Node(key, value));
                return;
            };
        }
        room[index].add(new Node(key, value));
    }
    @Override
    public V get(K key) {
        int index=hashKey(key);
        for (int i = 0; i < room[index].getSize(); i++) {
            if (room[index].get(i).key.equals(key)){
                return room[index].get(i).value;
            };
        }
        return null;
    }

    @Override
    public boolean exist(K key) {
        return get(key) != null;
    }

    @Override
    public void remove(K key){
        int index=hashKey(key);
        for (int i = 0; i < room[index].getSize(); i++) {
            if (room[index].get(i).key.equals(key)){
                room[index].remove(i);
                return;
            };
        }
    }

    @Override
    public void clear(){
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            room[i].clear();
        }
    }

    private int hashKey(K key){
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    private class Node {
        private K key;
        private V value;

        private Node(K key,V value) {
            this.key=key;
            this.value=value;
        }
    }
}
