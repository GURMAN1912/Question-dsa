import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int [] arr={10,1,2,7,6,1,5};

        CombinationSum ob=new CombinationSum();
        List<List<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> subsets = ob.sumK(arr,0,new ArrayList<>(),0,8 );
        // ob.sumElek(arr,0,6,new ArrayList<>(),ans );
        Arrays.sort(arr);
        ob.combinationSum2(arr,0,6,new ArrayList<>(),ans);
        // System.err.println(subsets);        
        System.err.println(ans);        
    }
    public List<List<Integer>> sumK(int[] arr,int i,List<Integer> temp,int sum,int k){
        List<List<Integer>> ans = new ArrayList<>();
        if (i == arr.length) {
            if(sum==k){
                ans.add(new ArrayList<>(temp));
            }
            return ans;
        }
        temp.add(arr[i]);
        ans.addAll(sumK(arr, i+1, temp, sum+arr[i], k));
        temp.remove(temp.size() - 1);
        ans.addAll(sumK(arr, i+1, temp, sum, k));
        return ans;
    }
    public void sumElek(int [] arr,int i,int k,List<Integer> temp,List<List<Integer>> ans){
        if(k<0 || i>=arr.length){
            return;
        }
            if(k==0){
                ans.add(new ArrayList<>(temp));
                return;
            }
        temp.add(arr[i]);
        sumElek(arr, i, k-arr[i], temp,ans);
        temp.remove(temp.size()-1);
        sumElek(arr, i+1, k, temp,ans);
    }
    public void combinationSum2(int[] arr,int i,int k,List<Integer> temp,List<List<Integer>> ans){
        if(k<0||i==arr.length){
            return;
        }
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int ind=i;ind<arr.length;ind++){
            if(ind>i && arr[ind]==arr[ind-1]){
                continue;
            }
            temp.add(arr[ind]);
            combinationSum2(arr, ind+1, k-arr[ind], temp, ans);
            temp.remove(temp.size()-1);
        }
        return;
    }

     
    
}
