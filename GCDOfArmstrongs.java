import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/*
This programs takes two integers as input and Calculated GCD of 
the Smallest and largest Armstrong numbers in the range.
*/
public class GCDOfArmstrongs{
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the 1st Number: ");
		Integer num1 = obj.nextInt();
		System.out.println("Enter the 2nd Number: ");
		Integer num2 = obj.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=num1; i<=num2; i++){
			if (isArmstrong(i)){
				arr.add(i);
			}
		}
		int first = arr.get(0);
		int last = arr.get(arr.size()-1);
		System.out.println(findGCD(first, last));
    }

    static boolean isArmstrong(int num) {
        int orinum = num;
        int remainder;
        int result = 0;
        int n = 0;

        orinum = num;

        for (; orinum != 0; orinum /= 10, ++n);
        orinum = num;

        while (orinum != 0) {
            remainder = orinum % 10;
            result += Math.pow(remainder, n);
            orinum /= 10;
        }
        return result == num;
    }

    static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

