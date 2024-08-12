package oops;

public class Main {
    public static void main(String[] args) {
        // Box b=new Box();
        // BoxWeight b1=new BoxWeight(2,3,5,6);
        // System.out.println(b.l);
        // System.out.println(b1.h);
        // System.out.println(b1.weight);
        Shapes shape=new Shapes();
        Circle circle=new Circle();
        Triangle triangle=new Triangle();
        shape.area();
        circle.area();
        triangle.area();
        Shapes s=new Circle();
        s.area();
        
    }
    
}
