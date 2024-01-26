import java.util.Scanner;

// Takes a integer as input and prints whether it is a prime or not.
public class isPrime{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int factors = 0;
		for (int i=1; i<=num; i++){
			if (num%i==0) {
				factors++;
			}
		}
		if (factors>2){
			System.out.println(num + " is not a prime number");
		}
		else{
			System.out.println(num + " is a prime number");
		}
	}
}