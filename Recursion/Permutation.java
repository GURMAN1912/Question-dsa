import java.util.ArrayList;
import java.util.List;

public class Permutation{
    public static void main(String[] args) {
        String str="abc";
        System.out.println( allPermutation(str,""));
        System.out.println(countPermutation(str,""));
        List<List<Integer>> ans=new ArrayList<>();
        int [] arr={1,2,3};
        allPermutationNumber(arr, 0, new ArrayList<>(), ans);
        System.err.println(arr);
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
    private static int countPermutation(String str,String p){
        if(str.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=str.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String e=p.substring(i,p.length());
            count =count+countPermutation(str.substring(1),f+ch+e);
        }
        return count;
    }
    private static void allPermutationNumber(int[] arr,int ind,List<Integer> temp,List<List<Integer>>ans){
        if(ind==arr.length){
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(arr,i,ind);
            allPermutationNumber(arr, ind+1, temp, ans);
            swap(arr,i,ind);
        }
    }
    private static void swap(int[] arr,int i,int ind){
        int t=arr[i];
            arr[i]= arr[ind];
            arr[ind]=t;
    }
}
