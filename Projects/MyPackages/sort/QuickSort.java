/*
 * Here is the Package implementation of Quick sort algorithm
 * for sorting a interger array
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages.sort;

public class QuickSort {

    // Partition method helper for quicksort
    int partition(int arr[], int low, int high){
        // First element as pivot
        int pivot = arr[low];
        // int st = low;
        // int end = high;
        int k = high;

        for (int i = high; i > low; i--) {
            if (arr[i] > pivot)
                swap(arr, i, k--);
        }
        swap(arr, low, k);
        return k;
    }

    // Swap method
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // main quick sort method
    public void quickSort(int arr[], int low, int high){
        if (low < high) {
            int idx = partition(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
