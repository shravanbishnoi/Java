import java.util.Scanner;

// Takes two numbers a prints the LCM of these numbers
public class findLCM{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another positive Number: ");
		int b = sc.nextInt();
		int lcm = findlcm(a, b);
		System.out.println("The LCM of two numbers is: "+ lcm);
	}

	private static int findGCD(int a, int b){
		if (b==0){
			return a;
		}
		else{
			return findGCD(b, a%b);
		}
	}

	public static int findlcm(int a, int b){
		int gcd = findGCD(a, b);
		return (a*b)/gcd;
	}
}