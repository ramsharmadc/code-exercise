package lang.java8.generics.bucket;

public class TestBucket {

    public static void main(String[] args) {

        Bucket<String, String> bucket = new Bucket<>();
        bucket.put("abc", "abc".getClass().getSimpleName());
        bucket.put("1", Integer.class.getSimpleName());
        bucket.put("true", boolean.class.getSimpleName());
        bucket.put("C", Character.class.getSimpleName());
        bucket.put("23.89023", Double.class.getSimpleName());
        bucket.put("2L", Long.class.getSimpleName());

        System.out.println(bucket);
        System.out.println(bucket.get("2L"));
        System.out.println(bucket.get(3));

        Bucket<Integer, String> bucket2 = new Bucket<>();
        // bucket2.put(1, "One");

        bucket2.put(1, "One");
        bucket2.put(2, "Two");
        bucket2.put(3, "Three");
        bucket2.put(4, "Four");
        bucket2.put(5, "Five");

        // System.out.println(bucket2.get(5));
        // System.out.println(bucket2.get(4));
        // System.out.println(bucket2.get(3));

        System.out.println(bucket2);
        System.out.println(bucket2.keySet());
        System.out.println(bucket2.valueSet());

        for (Bucket.Drop<Integer, String> drop : bucket2.drops()) {
            System.out.print(drop.getKey() + ":" + drop.getValue());

        }
    }

}
