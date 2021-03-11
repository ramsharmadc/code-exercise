package dsa.problemsolving.test0921;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person("P1", 23);
        Person p2 = new Person("P1", 30);
        Person p3 = new Person("P1", 32);
        Person p4 = new Person("P1", 21);
        Person p5 = new Person("P1", 22);
        Person p6 = new Person("P1", 43);
        Person p7 = new Person("P1", 42);
        Person p8 = new Person("P1", 31);
        Person p9 = new Person("P1", 32);
        Person p10 = new Person("P1", 33);

        List<Person> personList = new ArrayList<>(10);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
        personList.add(p7);
        personList.add(p8);
        personList.add(p9);
        personList.add(p10);

        int sumOfAges = personList.parallelStream().filter(x -> x.getAge() > 20)
                .flatMapToInt(x -> IntStream.of(x.getAge())).sum();

        System.out.println(sumOfAges);
    }
}