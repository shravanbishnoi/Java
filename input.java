import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class input{
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your First name: ");
		String fname = obj.nextLine();

		System.out.println("Enter your Last name: ");
		String lname = obj.nextLine();

		System.out.println("Enter your age: ");
		Integer age = obj.nextInt();

		System.out.println("Enter your marks: ");
		Float marks = obj.nextFloat();

		System.out.println("Your name is: "+ fname+" "+lname);	
		System.out.println("Your Age is: "+ age);
		System.out.println("Your Marks obtained is: "+ marks);


		System.out.println("Provide a Integer as input based on that a Astrick pattern will be created.");
		System.out.print("Enter an Interger: ");
		Integer n = obj.nextInt();
		int numstar = 1;
		int space = n-1;
		for (int i=1; i<=n; i++){
			for (int j=1; j<=space; j++){
				System.out.print(" ");
			}
			for (int k=1; k<=numstar; k++){
				System.out.print("*");
			}
			numstar = numstar+2;
			space = space-1;
			System.out.println();
		}
    }
}
