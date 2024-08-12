package oops;

public class Box {
    public double l;    
    public double w;    
    public double h; 

    public Box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }  

    public Box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
        System.out.println("Called");
    }

    public Box(Box other) {
        this.l = other.l;
        this.w = other.w;
        this.h = other.h;
    }

    public void display() {
        System.out.println("called");
    }
}
