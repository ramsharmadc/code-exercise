package lang.java8.collections.map;

import java.util.*;

public class TreeMapCheck {

    private static final Comparator<Map.Entry<Integer, Employee>> entryComparator =
            Comparator.comparingInt(o -> o.getValue().id);

    public static void main(final String[] args) {

        final Map<Integer, Employee> employeeMap = new TreeMap<>();
        final TreeMap<Map.Entry<Integer, Employee>, Integer> employeeMapSortedOnValue =
                new TreeMap(entryComparator);

        employeeMap.put(4, new Employee(123, Calendar.getInstance().getTime()));
        employeeMap.put(6, new Employee(456, Calendar.getInstance().getTime()));
        employeeMap.put(9, new Employee(356, Calendar.getInstance().getTime()));
        employeeMap.put(3, new Employee(789, Calendar.getInstance().getTime()));
        employeeMap.put(7, new Employee(676, Calendar.getInstance().getTime()));

        employeeMapSortedOnValue
                .put(new CustomEntry(4, new Employee(123, Calendar.getInstance().getTime())), 4);
        employeeMapSortedOnValue
                .put(new CustomEntry(6, new Employee(456, Calendar.getInstance().getTime())), 6);
        employeeMapSortedOnValue
                .put(new CustomEntry(9, new Employee(356, Calendar.getInstance().getTime())), 9);
        employeeMapSortedOnValue
                .put(new CustomEntry(3, new Employee(789, Calendar.getInstance().getTime())), 3);
        employeeMapSortedOnValue
                .put(new CustomEntry(7, new Employee(676, Calendar.getInstance().getTime())), 7);

        System.out.println(employeeMap);
        System.out.println(employeeMapSortedOnValue);
    }

    static class CustomEntry implements Map.Entry<Integer, Employee> {
        Integer key;
        Employee value;

        public CustomEntry(Integer k, Employee e) {
            this.key = k;
            this.value = e;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public Employee getValue() {
            return value;
        }

        @Override
        public Employee setValue(Employee value) {
            Employee oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "Map.Entry{" + "key=" + key + ", value=" + value.id + '}';
        }
    }

    static class Employee implements Comparable<Employee> {
        Integer id;
        Date doj;

        public Employee(final Integer id, final Date doj) {
            this.id = id;
            this.doj = doj;
        }

        public Integer getId() {
            return id;
        }

        public void setId(final Integer id) {
            this.id = id;
        }

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public String toString() {
            return "Employee{" + "id=" + id + '}';
        }
    }
}
