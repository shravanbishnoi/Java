/*
 * Here is the Package implementation of Bubble sort algorithm
 * for sorting a interger array
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages.sort;

public class BubbleSort {
    public int[] bubbleSort(int[] array){
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length-i-1; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}