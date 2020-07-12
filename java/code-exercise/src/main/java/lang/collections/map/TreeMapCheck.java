package lang.collections.map;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapCheck {

    public static void main(final String[] args) {

        System.out.println("Checking how Tree map works");

        final Map<Employee, Integer> employeeMap = new TreeMap<>();
        employeeMap.put(new Employee(123, Calendar.getInstance().getTime()), 3);
        employeeMap.put(new Employee(456, Calendar.getInstance().getTime()), 3);

    }

    static class Employee {
        Integer id;
        Date doj;

        public Integer getId() {
            return id;
        }

        public void setId(final Integer id) {
            this.id = id;
        }

        public Date getDoj() {
            return doj;
        }

        public void setDoj(final Date doj) {
            this.doj = doj;
        }

        public Employee(final Integer id, final Date doj) {
            this.id = id;
            this.doj = doj;
        }
    }
    
}