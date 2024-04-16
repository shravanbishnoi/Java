public class Testthrow {
    public static void iseligible(int age){
        if (age<18){
            throw new IllegalArgumentException("\nYou are not eligible");
        }
        else{
            System.out.println("You are eligible and can vote");
        }
    }
    public static void main(String[] args) {
        iseligible(1);
        System.out.println("Rest of the code...");
    }
}