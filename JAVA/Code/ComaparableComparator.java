import java.util.*;


/**
 * Employee
 */
class Employee implements Comparable<Employee>{
    int id;
    int salary;

    Employee(int id, int salary){
        this.id = id;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }    
}


public class ComaparableComparator {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(101, 50000));
        list.add(new Employee(105, 60000));
        list.add(new Employee(102, 55000));
        list.add(new Employee(104, 45000));
        list.add(new Employee(103, 70000));
        Collections.sort(list);
        for (Employee emp: list){
            System.out.println(emp.id+" "+ emp.salary);
        }
        
    }
}
