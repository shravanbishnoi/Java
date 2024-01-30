/*
 * This file contains implementation for Binary search 
 * in an array, for finding a target element in array
 * 
 * Author: Shravan
 * Date: 29-01-2024
 */

import java.util.Arrays;

// Main mathod
public class BinarySearch {
    public static void main(String[] args) {
        binSearch s = new binSearch();
        int array[] = {3, 5, 0, 1, 2, 6};
        Arrays.sort(array);
        int target = 1;
        System.out.println(s.binarySearch(array, target));
    }     
}

// Helper class that implements the binary search method
// Takes a sorted array and a target element
// returns the index if the element is present otherwise -1
class binSearch {
    public int binarySearch(int[] array, Integer target){
        int left = 0;
        int right = (array.length)-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (array[mid]==target){
                return mid;
            }
            else if (array[mid]<target){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}