import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4};
        int[] dset = {1,2,2};
        List<List<Integer>> subsets = subset(set, 0, new ArrayList<>());
        List<List<Integer>> dulsubsets = duplicateArray(dset);
        List<Integer> Sum=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        subset2(dset, 0,new ArrayList<>(),ans);
        subsetSum(set, 0, 0,Sum);
        // System.out.println(subsets);
        // System.out.println(dulsubsets);
        Collections.sort(Sum);
        System.out.println(ans);
    }

    private static List<List<Integer>> subset(int[] arr, int i, List<Integer> temp) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == arr.length) {
            ans.add(new ArrayList<>(temp));
            return ans;
        }
        
        // Include the current element
        temp.add(arr[i]);
        ans.addAll(subset(arr, i + 1, temp));
        temp.remove(temp.size() - 1);
        
        // Exclude the current element
        ans.addAll(subset(arr, i + 1, temp));

        return ans;
    }
    private static List<List<Integer>> duplicateArray(int[] arr) {
        Arrays.sort(arr);  // Sort the array to handle duplicates
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());  // Start with an empty subset

        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // If current element is the same as the previous one, adjust start to avoid duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    private static void subsetSum(int arr[],int sum, int i,List<Integer> temp ){
        if(i==arr.length){
            temp.add(sum);
            return;
        }
        subsetSum(arr,sum+arr[i], i+1, temp);
        subsetSum(arr,sum, i+1, temp);
    }
    public static void subset2(int[] arr,int ind,List<Integer> temp,List<List<Integer>> ans){
            ans.add(new ArrayList<>(temp));
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            temp.add(arr[i]);
            subset2(arr, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
        return;
    }
}
