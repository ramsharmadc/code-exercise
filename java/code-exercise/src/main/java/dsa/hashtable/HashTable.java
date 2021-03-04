package dsa.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HashTable<K, V> implements SymbolTable<K, V> {

    private Entry<K, V>[] backed_array;
    private int index;

    public HashTable() {
        this(10);
    }

    public <T> HashTable(final int size) {
        this.backed_array = new Entry[size];
    }

    private int hash_code(K key) {
        index = key.hashCode();
        return (index % backed_array.length);
    }

    private void skip_copy_array(int index_to_skip) {
        Entry<K, V>[] new_array = new Entry[backed_array.length - 1];
        for (int i = 0; i < backed_array.length; i++) {
            if (i != index_to_skip) {
                if (i < index_to_skip)
                    new_array[i] = backed_array[i];
                else
                    new_array[i - 1] = backed_array[i];
            }
        }
        backed_array = new_array;
    }

    @Override
    public void put(K key, V value) {
        if ((Integer) key >= backed_array.length) {
            resize_hash_table();
        }
        index = hash_code(key);
        Entry<K, V> e = new Entry<K, V>();
        e.key = key;
        e.value = value;
        backed_array[index] = e;
    }

    private void resize_hash_table() {
        Entry<K, V>[] new_table = new Entry[backed_array.length * 2];
        copy_old_table_to_new(new_table);
    }

    private void copy_old_table_to_new(Entry<K, V>[] new_table) {
        for (int i = 0; i < backed_array.length; i++) {
            new_table[i] = backed_array[i];
        }
        backed_array = new_table;
    }

    @Override
    public V get(K key) {
        index = hash_code(key);
        return backed_array[index] != null
                ? (backed_array[index].key.equals(key) ? backed_array[index].value : null)
                : null;
    }

    @Override
    public void remove(K key) {
        if (key != null) {
            for (int i = 0; i < backed_array.length; i++) {
                index = hash_code(key);
                if (backed_array[index] != null && backed_array[index].key.equals(key)) {
                    skip_copy_array(index);
                    return;
                }
            }
        }
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public boolean is_empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return backed_array.length;
    }

    @Override
    public Iterable<K> keys() {
        Set keys = new HashSet<K>();
        for (Entry e : backed_array)
            if (e != null)
                keys.add(e.key);
        return keys;
    }

    protected class Entry<K, V> {
        K key;
        V value;
    }
}
