/*
 * This file contains implementation for linear search 
 * in an array, for finding a target element in array
 * 
 * Author: Shravan
 * Date: 29-01-2024
 */

// main method
public class LinearSearch {
    public static void main(String[] args) {
        Search s = new Search();
        int numbers[] = {3, 5, 1, 2, 6};
        int target = 1;
        System.out.println(s.linearSearch(numbers, target));
    }     
}

// Helper class that implements the Linear search method
// Takes an array and a target element
// returns the index if the element is present otherwise -1
class Search {
    public int linearSearch(int[] array, Integer target){
        for (int i=0; i<array.length; i++){
            if (array[i]==(target)){
                return i;
            }
            else{
                continue;
            }
        }
        return -1;
    }
}


