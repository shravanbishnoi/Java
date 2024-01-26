import java.util.Scanner;


// Takes a positive int no. as input
// prints the factorial of that number
public class findFactorial{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive Integer: ");
		int num = sc.nextInt();
		int fact = factorial(num);
		System.out.println(fact);
	}

	public static int factorial(int a){
		if (a==1){
			return a;
		}
		return a*factorial(a-1);
	}
}