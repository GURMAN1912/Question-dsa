import java.util.HashMap;

public class Substring {
    public static void main(String[] args) {
        Substring obj=new Substring();
        String str="cadbzabcd";
        String s="aaabbccccd";
        System.err.println(obj.wihtoutRepeatingCharacter(str));
        System.err.println(obj.atmostDistinctCharacter(s,2));
        System.err.println(obj.countAllThree("bbacba"));
        System.err.println(obj.atmostDistinctCharacter("AAABBDCD",2));
    }
    public int atmostDistinctCharacter(String s,int k){
        int l=0;
        int r=0;
        int maxL=0;
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while (r<s.length()) {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r), 0)+1);
            if(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
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
    public int wihtoutRepeatingCharacter(String s){
        int l=0;
        int r=0;
        int len=0;
        int maxL=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while (r<s.length()) {
            if(map.containsKey(s.charAt(r))){
               if(map.get(s.charAt(r))>=l){
                    l=map.get(s.charAt(r))+1;
               } 
            }        
            len=r-l+1;
            maxL=Math.max(len, maxL);
            map.put(s.charAt(r),r);
            r++;
        } 
        return maxL;
    }
    public int countAllThree(String s){
        int count=0;
        int [] lastScene={-1,-1,-1};
        for(int i=0;i<s.length();i++){
            lastScene[s.charAt(i)-'a']=i;
            if(lastScene[0]!=-1&&lastScene[1]!=-1&&lastScene[2]!=-1){
                count+=1+Math.min(lastScene[2],Math.min(lastScene[0],lastScene[1]));
            }
        }
        return count;
    }
    public int characterReplacement(String s,int k){
        int l=0;int r=0;
        int maxl=0;int maxf=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(map.get(s.charAt(r)), 0)+1);
            maxf=map.get(s.charAt(r));
            if((r-l+1)-maxf>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            if((r-l+1)-maxf<=k){
                maxl=Math.max(maxl,r-l+1);
            }
            r++;
        }
        return maxl;
    }
}
