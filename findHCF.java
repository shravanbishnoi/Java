import java.util.Scanner;

// Takes two numbers a prints the HCF of these numbers
public class findHCF{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another positive Number: ");
		int b = sc.nextInt();
		int hcf = findhcf(a, b);
		System.out.println("The HCF of two numbers is: "+ hcf);
	}

	public static int findhcf(int a, int b){
		while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
	}
}