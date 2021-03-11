package dsa.datastructures.hashtable;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HashTable<Integer, Integer> ht = new HashTable<Integer, Integer>(10);
        ht.put(1, 1);
        ht.put(2, 2);
        ht.put(3, 3);
        ht.put(4, 4);
        ht.put(29, 29);
        ht.put(4, 40);

        System.out.println(ht.get(1));
        System.out.println(ht.get(2));
        System.out.println(ht.get(3));
        System.out.println(ht.get(4));
        System.out.println(ht.get(29));

        ht.remove(4);
        System.out.println(ht.get(4));

        ht.put(24, 24);
        ht.put(12, 12);
        ht.put(45, 45);
        ht.put(50, 50);
        ht.put(450, 450);
        System.out.println(ht.get(24));
        System.out.println(ht.get(12));
        System.out.println(ht.get(45));
        System.out.println(ht.get(450));
        System.out.println(ht.get(50));

        ht.remove(45);
        System.out.println(ht.get(45));
        System.out.println(ht.get(450));

        System.out.println("ht.size()==" + ht.size());
        System.out.println("ht.is_empty()==" + ht.is_empty());

        System.out.print(ht.keys());
    }
}
