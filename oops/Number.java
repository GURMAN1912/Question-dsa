package oops;

public class Number {
    public int sum(int a,int b,int c){
        return a+b+c;
    }
    public int sum(int a,int b){
        return a+b;
    } 
    public static void main(String[] args) {
        Number n=new Number();
        System.out.println(n.sum(2, 3));
        System.out.println(n.sum(2, 3,9));
    }
}
