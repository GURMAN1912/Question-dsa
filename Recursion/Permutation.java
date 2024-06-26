import java.util.ArrayList;
import java.util.Arrays;

public class Permutation{
    public static void main(String[] args) {
        String str="abc";
        System.out.println( allPermutation(str,""));
    }
    private static ArrayList<String> allPermutation(String str,String p){
        if(str.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();

        char ch=str.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
            ans.addAll(allPermutation(str.substring(1),f+ch+e));
        }
        return ans;
    }
}