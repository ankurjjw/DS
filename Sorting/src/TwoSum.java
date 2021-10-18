import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] A = {0,3,2,5,4,6,8,9};
        int sum = 8;

        Map<Integer, Integer> twoSum = new HashMap<>();


        for(int i=0;i<A.length;i++){

            int n=sum-A[i];
            if(twoSum.containsValue(n)){
                System.out.println("Found: [" + A[i] + "," + (sum-A[i]) + "]");
            }
            twoSum.put(i, A[i]);

        }
    }
}
