/*
 * This is a java test file for testing the packages created 
 * for basic data structures: Stack, Queue, LinkedList
 * and for searching and sorting packages.
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages;
import MyPackages.datastructures.*;
import MyPackages.search.*;
import MyPackages.sort.*;


public class testPackages {
    public static void main(String[] args) {
        // Testing Stack Implementation
        System.out.println("TESTING STACK PACKAGE\n");
        Stack s1 = new Stack(10);
        s1.push(1);
        s1.push(2);
        s1.peek();
        s1.isEmpty();
        s1.pop();
        System.out.println("Current stack size is: "+ s1.size());
        System.out.println();

        // Testing Queue Implementation
        System.out.println("TESTING QUEUE PACKAGE\n");
        Queue q = new Queue();
        q.deQueue();
        // insert elements to the queue
        for(int i = 1; i < 6; i ++) {
            q.enQueue(i);
        }
        // 6th element can't be added to queue because queue is full
        q.enQueue(6);
        q.display();
        q.deQueue();
        q.display();
        System.out.println();

        // Testing LinkedList Implementation
        System.out.println("TESTING LINKEDLIST PACKAGE\n");
        LinkedList l = new LinkedList();
        l.show();
        for (int i = 1; i < 3; i++) {
            l.addFirst(i);
        }
        l.show();
        l.addLast(4);
        l.show();
        System.out.println("Size of Linked List is: " +l.getSize());
        l.deleteFirst();
        l.show();
        System.out.println("Size of Linked List is: " + l.getSize());
        l.deleteLast();
        l.show();
        System.out.println("Size of Linked List is: " + l.getSize());
        l.addAtPos(7, 1);
        l.show();
        System.out.println("Size of Linked List is: " + l.getSize());
        System.out.println();

        // Testing Search Package
        System.out.println("TESTING LINEAR SEARCH PACKAGE\n");
        LinearSearch s = new LinearSearch();
        int numbers[] = {3, 5, 1, 2, 6};
        int target = 1;
        System.out.println(s.linearSearch(numbers, target));

        // Testing Search Package
        System.out.println("TESTING BINARY SEARCH PACKAGE\n");
        BinarySearch b = new BinarySearch();
        int arr[] = {1, 2, 6, 9, 10, 16, 29, 42};
        int tar = 1;
        System.out.println(b.binarySearch(arr, tar));
        System.out.println();

        // Testing Sort Package
        System.out.println("TESTING SORT PACKAGE\n");
        BubbleSort bs = new BubbleSort();
        int num[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8, -1};
        int[] num2 = bs.bubbleSort(num);
        System.out.println("Sorted by bubble sort: ");
        bs.printArray(num2);

        System.out.println("Sorted by insertion sort: ");
        InsertionSort is = new InsertionSort();
        int insertionarr[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8, -1};
        is.insertionSort(insertionarr);
        is.printArray(insertionarr);

        System.out.println("Sorted by selection sort: ");
        SelectionSort ss = new SelectionSort();
        int selarr[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8, -1};
        int[] selarr2 = ss.selectionSort(selarr);
        ss.printArray(selarr2);

        System.out.println("Sorted by quick sort: ");
        QuickSort qs = new QuickSort();
        int quiarr[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8, -1};
        qs.quickSort(quiarr, 0, quiarr.length-1);
        qs.printArray(quiarr);

        System.out.println("Sorted by merge sort: ");
        MergeSort ms = new MergeSort();
        int merarr[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8, -1};
        ms.mergeSort(merarr, 0, merarr.length-1);
        ms.printArray(merarr);
    }
}