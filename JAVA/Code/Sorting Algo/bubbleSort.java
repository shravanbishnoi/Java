/*
 * Here is the implementation of Bubble sort algorithm
 * for sorting a interger array
 * 
 * Author: Shravan
 * Date: 31-01-2024
 */

// Main class
public class bubbleSort {
    public static void main(String[] args) {
        Search s = new Search();
        int num[] = {0, 3, 43, 11, 34, 5, 10, 2, 6, 1, 8};
        int[] num2 = s.BubbleSort(num);
        for (int i:num2){
            System.out.println(i);
        }
    }     
}

// Helper class containg BubbleSort method to sort a array of intergers
class Search {
    public int[] BubbleSort(int[] array){
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
}


