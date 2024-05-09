import java.util.*;

/**
 * Employee
 */
class Employee{
    int age;
    int salary;

    Employee(int age, int salary){
        this.age = age;
        this.salary = salary;
    }
}

class AgeComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2){
        return e1.age-e2.age;
    }
}

class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2){
        return e1.salary-e2.salary;
    }
}

public class ComparableComparator {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(101, 50000));
        list.add(new Employee(105, 60000));
        list.add(new Employee(102, 55000));
        list.add(new Employee(104, 45000));
        list.add(new Employee(103, 70000));

        AgeComparator ac = new AgeComparator();
        SalaryComparator sc = new SalaryComparator();

        // Sorted by Age
        Collections.sort(list, ac);
        System.out.println("Sorted by Age: ");
        for (Employee emp: list){
            System.out.println(emp.age+" "+ emp.salary);
        }
        // Sorted by Salary
        Collections.sort(list, sc);
        System.out.println("");
        System.out.println("Sorted by Salary: ");
        for (Employee emp: list){
            System.out.println(emp.age+" "+ emp.salary);
        }

    }
}
