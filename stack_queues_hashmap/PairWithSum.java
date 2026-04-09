import java.util.*;

public class PairWithSum {
    public static void main(String[] args){
        int[] arr={1,4,45,6,10,8};
        int target=16;
        Set<Integer> set=new HashSet<>();

        for(int x:arr){
            if(set.contains(target-x)){
                System.out.println("Pair found");
                return;
            }
            set.add(x);
        }
        System.out.println("No pair");
    }
}
