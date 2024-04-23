interface AREA {
    double findArea(double pi, double r);    
}

public class FIArea {
    public static void main(String[] args) {
        double pi = 3.14;
        double radius = 5.3;

        AREA obj = (p,r)-> pi*r*r;
        System.out.println(obj.findArea(pi, radius));
    }
}