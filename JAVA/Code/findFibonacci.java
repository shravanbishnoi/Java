import java.util.Scanner;


// Takes int n as input and prints first n numbers in fibonacci series 
public class findFibonacci{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive number: ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
            System.out.print(fibonacci(i) + " ");
        }
	}

	public static int fibonacci(int a){
		if (a<=1){
			return a;
		}
		else{
			return fibonacci(a-1) + fibonacci(a-2);
		}
	}
}