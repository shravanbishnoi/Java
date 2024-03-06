/*
 * In this file we will learn to make a class variable 
 * Generic, and pass whatever datatype when creating a
 * object.
 * 
 * Author: Shravan
 * Date: 06-03-2023
 */

class Student<T1, T2> {
    // T1, T2 to make it generic
    // can what any datatype
    T1 rollNo;
    T2 Name;

    void setValue(T1 a, T2 b){
        rollNo = a;
        Name = b;
    }
    void showValue(){
        System.out.println(rollNo+"-"+ Name);
    }
}

/**
 * 
 *GenericMethod
 */
class GenericMethod {
    public <E> void printArray(E[] elements){
        for (E element: elements){
            System.out.println(element);
        }
        System.out.println();
    }
}


public class GenericClassTemplate {
    public static void main(String[] args) {
        Student<Integer, String> sc = new Student<Integer, String>();
        sc.setValue(1, "Shravan");
        sc.showValue();

        // Generic Method
        GenericMethod gm = new GenericMethod();
        Integer[] intArray = {10, 20, 30, 40};
        Character[] charArray = {'A', 'B', 'C'};

        System.out.println("Printing Integer Array: ");
        gm.printArray(intArray);

        System.out.println("Printing Character Array: ");
        gm.printArray(charArray);
    }   
}
