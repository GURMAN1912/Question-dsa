import java.util.HashMap;

public class Friut {
    public static void main(String[] args) {
        Friut ob=new Friut();
        int arr[]={3,3,3,1,2,1,1,2,3,3,4};
        System.err.println(ob.maxFriut(arr,2));
    }
    public int maxFriut(int[] arr,int k){
        int l=0;
        int r=0;
        int maxL=0;
        int len=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while (r<arr.length) {
            map.put(arr[r],map.getOrDefault(arr[r], 0)+1);
            if(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            if(map.size()<=k){
                len=r-l+1;
                maxL=Math.max(maxL, len);
            }
            r++;
        }
        return maxL;
    }
}
