import java.util.Scanner;

public class isArmstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        scanner.close();
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
}
