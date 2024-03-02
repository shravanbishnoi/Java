/*
 * This file package contains implementation for Binary search 
 * in an array, for finding a target element in array
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages.search;

// Takes a sorted array and a target element
// returns the index if the element is present otherwise -1
public class BinarySearch {
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