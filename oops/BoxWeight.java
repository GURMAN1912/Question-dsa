package oops;

public class BoxWeight extends Box {
    public double weight;
    public BoxWeight(){
        super();
        this.weight=-1;
    }    
    public BoxWeight(double l,double w,double h,double weight){
        super(l, w, h);
        this.weight=weight;
    }
}
