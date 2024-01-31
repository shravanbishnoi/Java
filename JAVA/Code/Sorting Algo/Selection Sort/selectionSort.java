/*
 * Here is the implementation of Selection sort algorithm
 * for sorting a interger array
 * 
 * Author: Shravan
 * Date: 31-01-2024
 */

 import java.io.*;


// Main class
public class selectionSort {
    public static void main(String[] args) throws Exception {
        Search s = new Search();
        int num[] = {0, 3, 43, 6, 1, 8, -1};
        int[] num2 = s.SelectionSort(num);
        for (int i:num2){
            System.out.print(i+" ");
        }

        // // For reading the space separated numbers from a text file and sort using selection sort
        // File file = new File("C:\\Users\\Shravan Bishnoi\\OneDrive\\Desktop\\JAVA\\Programs\\Sorting Algo\\ArrayToSort.txt");
        // BufferedReader br = new BufferedReader(new FileReader(file));
        // String[] line = br.readLine().split(" ");
        // int num[] = new int[line.length];
        // for (int i=0; i<line.length; i++){
        //     num[i] = Integer.parseInt(line[i]);
        // }
    }     
}

// Helper class containg SelectionSort method to sort a array of intergers
class Search {
    public int[] SelectionSort(int[] array){
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}


