import java.util.*;
/**
 * StudentComparatorSort
 */
class Student {
    int rn;
    String name;
    String sname;

    Student(int r, String n, String sn){
        this.rn = r;
        this.name = n;
        this.sname = sn;
    }
}
class RollNumberCom implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.rn-s2.rn;
    }
}

class NameCom implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}
class SnameCom implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.sname.compareTo(s2.sname);
    }
}


/**
 * StudentComparatorSort
 */
public class StudentComparatorSort {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(101, "Shravan", "Bishnoi"));
        list.add(new Student(105, "Divyansh", "Mishra"));
        list.add(new Student(102, "Abhi", "Shou"));
        list.add(new Student(104, "Sonu", "Datta"));
        list.add(new Student(103, "Alia", "Yadav    "));

        RollNumberCom ac = new RollNumberCom();
        NameCom sc = new NameCom();
        SnameCom sn = new SnameCom();

        // Sorted by Rollnumber
        Collections.sort(list, ac);
        System.out.println("Sorted by Rollnumber: ");
        for (Student emp: list){
            System.out.println(emp.rn+" "+emp.name+" "+ emp.sname);
        }
        // Sorted by Name
        Collections.sort(list, sc);
        System.out.println("");
        System.out.println("Sorted by Name: ");
        for (Student emp: list){
            System.out.println(emp.rn+" "+ emp.name+" "+ emp.sname);
        }
        // Sorted by last name
        Collections.sort(list, sn);
        System.out.println("");
        System.out.println("Sorted by Last Name: ");
        for (Student emp: list){
            System.out.println(emp.rn+" "+ emp.name+" "+ emp.sname);
        }

    }
}
