package lang.java8.exception;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CheckException<E> {

    public static void main(String[] args) {

        PriorityQueue<String> todo = new PriorityQueue<String>();
        todo.add("dishes");
        todo.add("laundary");
        todo.add("bills");
        todo.add("bills");

        System.out.print(todo.size() + " " + todo.poll());
        System.out.print(" " + todo.peek() + " " + todo.poll());
        System.out.print(" " + todo.poll() + " " + todo.poll());

        String[] a = {"Bangalore", "Pune", "San Francisco", "New York City"};

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }

        });

        System.out.println(Arrays.binarySearch(a, "New York City"));

        /*
         * try{ System.out.println(Integer.parseInt("x")); }catch (Exception e){
         * System.out.println("erewr"); Integer.parseInt("x"); }
         */

        /*
         * // check the resource allocation here in jdk1.7 try (BufferedReader br = new
         * BufferedReader(new InputStreamReader(System.in))) { new
         * CheckException<Object>().justaMethod(); throw new Throwable(); }
         *
         * // catch(E instanceof Throwable) {}
         *
         * catch (Exception e) { System.out.println("Exception thrown :" + e.getLocalizedMessage());
         *
         * } catch (Throwable th) { } // this is fine as this is superclass of e // catch(Exception
         * ee) {} // Exception already handled in the above // 'catch' clause //
         * catch(RuntimeException re) { } // this is also a compile error
         */
    }

    public void justaMethod() {
        try {
            // throw new ClassCastException();
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Excpetion caught : " + e.getMessage());
            // throw new NullPointerException();
            // throw new Exception(); // u can't uncomment this line
        }
    }
}
