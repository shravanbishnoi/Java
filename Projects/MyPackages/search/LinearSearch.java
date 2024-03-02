/*
 * This package contains implementation for linear search 
 * in an array, for finding a target element in array
 * 
 * Author: Shravan
 * Date: 01-03-2024
*/

package MyPackages.search;

// Takes an array and a target element
// returns the index if the element is present otherwise -1
public class LinearSearch {
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


