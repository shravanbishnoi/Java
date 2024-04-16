public class Testthrows {
    public static int divideNum(int a, int b) throws ArithmeticException{
        int div = a/b;
        return div;
    }
    public static void main(String[] args) {
        // Testthrow obj = new Testthrow();
        try{
            System.out.println(divideNum(45, 0));
        }
        catch (ArithmeticException e){
            System.out.println("\nNumber cannot be divided by 0");
        }
        System.out.println("Rest of the code");
    }
}