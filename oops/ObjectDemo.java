package oops;

public class ObjectDemo {
    int num;
    float gpa;
    ObjectDemo(int num,float gpa){
        this.num=num;
        this.gpa=gpa;
    }
    @Override
    public boolean equals(Object obj){
        return this.num==((ObjectDemo)obj).num;        
    }
    public static void main(String[] args) {
        ObjectDemo ob1=new ObjectDemo(10, 2.3f);
        ObjectDemo ob2=new ObjectDemo(12, 2.9f);
        System.out.println(ob1.equals(ob2));
    }
}
