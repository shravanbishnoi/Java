interface INF1 {
    String display();    
}

public class Functionalinterface {

    public static void main(String[] args) {
        INF1 obj1 = ()->{
            return "Hi";
        };
        INF1 obj2 = ()->{return "Hii";};
        INF1 obj3 = ()-> "Hiii";

        System.out.println(obj1.display());
        System.out.println(obj2.display());
        System.out.println(obj3.display());
    }
}