import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args){
        int[] arr={1,-1,2,-2,3};
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,count=0;

        for(int x:arr){
            sum+=x;
            if(sum==0) count++;
            if(map.containsKey(sum)) count+=map.get(sum);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(count);
    }
}
