/*
Creating a 3x3 matrix of integers with the following conditions.
    1) You can use 9 integers between 1 to 9 where is number is unique (i.e. no repeating of numbers)
    2) Sum of all the row elements will be 15
    3) Sum of all the column elements will be 15
    4) Sum of all the diagonal elements will be 15

Author: Shravan
Date: 23-04-2024
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> possiblePairs = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i != j && j != k && k != i) {
                        if (i + j + k == 15) {
                            String num = "" + i + j + k;
                            possiblePairs.add(num);
                        }
                    }
                }
            }
        }
        int[][] finalMatrix = getMatrix(possiblePairs);
        printMatrix(finalMatrix);
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int target = 15;
        for (int[] row : matrix) {
            if (Arrays.stream(row).sum() != target) {
                return false;
            }
        }
        for (int col = 0; col < 3; col++) {
            int colSum = 0;
            for (int row = 0; row < 3; row++) {
                colSum += matrix[row][col];
            }
            if (colSum != target) {
                return false;
            }
        }
        int diagonal1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
        int diagonal2 = matrix[0][2] + matrix[1][1] + matrix[2][0];
        return diagonal1 == target && diagonal2 == target;
    }

    public static int[][] getMatrix(List<String> possiblePairs) {
        for (int i = 0; i < possiblePairs.size(); i++) {
            for (int j = i + 1; j < possiblePairs.size(); j++) {
                String num1 = possiblePairs.get(i);
                String num2 = possiblePairs.get(j);
                
                if (!hasCommonElements(num1, num2)) {
                    String combined = num1 + num2;
                    for (int k = j + 1; k < possiblePairs.size(); k++) {
                        String num3 = possiblePairs.get(k);
                        if (!hasCommonElements(combined, num3)) {
                            String number = combined + num3;
                            int[] matrix = number.chars().map(Character::getNumericValue).toArray();
                            List<int[]> permutations = getPermutations(matrix);
                            
                            for (int[] permutation : permutations) {
                                int[][] permMatrix = convertToMatrix(permutation);
                                if (isMagicSquare(permMatrix)) {
                                    return permMatrix;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean hasCommonElements(String str1, String str2) {
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static List<int[]> getPermutations(int[] arr) {
        List<int[]> permutations = new ArrayList<>();
        getPermutations(arr, 0, permutations);
        return permutations;
    }

    private static void getPermutations(int[] arr, int index, List<int[]> permutations) {
        if (index == arr.length - 1) {
            permutations.add(arr.clone());
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getPermutations(arr, index + 1, permutations);
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[][] convertToMatrix(int[] arr) {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 9; i++) {
            matrix[i / 3][i % 3] = arr[i];
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}