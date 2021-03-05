package dsalgo.hashtable;

/**
 * Created by ramsharma on 08-05-2016.
 */
public interface SymbolTable<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    boolean contains(K key);

    boolean is_empty();

    int size();

    Iterable<K> keys();
}
