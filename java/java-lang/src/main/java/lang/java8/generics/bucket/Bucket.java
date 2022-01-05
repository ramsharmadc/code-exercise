package lang.java8.generics.bucket;

import java.util.*;

public class Bucket<K, V> {

    // private K key;
    // private V value;

    private final List<Drop<K, V>> myList;

    public Bucket() {

        // this.key = null;
        // this.value = null;
        myList = new LinkedList<Drop<K, V>>();
    }

    /*
     * private Bucket(K key, V value) { this.key = key; this.value = value; }
     */

    public Set<Drop<K, V>> drops() {

        if (myList != null) {
            Set<Bucket.Drop<K, V>> set = new HashSet<>();
            Iterator<Drop<K, V>> itr = myList.iterator();
            while (itr.hasNext()) {
                Drop<K, V> drop = itr.next();
                set.add(drop);
            }
            return set;
        } else
            throw new NullPointerException();
    }

    public V get(int index) {

        if (myList != null) {
            return myList.get(index).value;
        } else
            throw new NullPointerException();
    }

    public V get(K key) {

        V value = null;
        if (myList != null) {
            Iterator<Drop<K, V>> itr = myList.iterator();
            while (itr.hasNext()) {
                Drop<K, V> genr = itr.next();
                if (genr.key.equals(key))
                    return genr.value;
            }
        } else
            throw new NullPointerException();
        return value;
    }

    public Set<K> keySet() {

        Set<K> set = new HashSet<>();
        if (myList != null) {
            Iterator<Drop<K, V>> itr = myList.iterator();
            while (itr.hasNext()) {
                Drop<K, V> genr = itr.next();
                set.add(genr.key);
            }
            return set;
        } else
            throw new NullPointerException();
    }

    public void put(K key, V value) {

        myList.add(new Drop<K, V>(key, value));
    }

    @Override
    public String toString() {

        if (myList != null) {
            Iterator<Drop<K, V>> itr = myList.iterator();
            StringBuffer str = new StringBuffer();
            str.append("[");
            if (!itr.hasNext())
                str.append("]");

            while (itr.hasNext()) {
                Drop<K, V> gnr = itr.next();
                str.append(gnr.key + ":" + gnr.value);
                if (itr.hasNext())
                    str.append(", ");
                else
                    str.append("]");
            }

            return str.toString();
        } else
            return "[]";
    }

    public Set<V> valueSet() {

        Set<V> set = new HashSet<>();
        if (myList != null) {
            Iterator<Drop<K, V>> itr = myList.iterator();
            while (itr.hasNext()) {
                Drop<K, V> genr = itr.next();
                set.add(genr.value);
            }
            return set;
        } else
            throw new NullPointerException();
    }

    protected final static class Drop<K, V> {

        private final K key;
        private final V value;

        private Drop(K key, V value) {

            this.key = key;
            this.value = value;
        }

        public K getKey() {

            return this.key;
        }

        public V getValue() {

            return this.value;
        }
    }
}
