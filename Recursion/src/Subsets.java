import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<Integer[]> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<Integer> slateInt = new ArrayList<>();

        subsetHelper(input, 0, slateInt);

        for(Integer[] arr: result){
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void subsetHelper(int[] input, int idx, List<Integer> slate) {

        if(idx>=input.length){
            result.add(slate.toArray(new Integer[0]));
            return;
        }
        subsetHelper(input, idx+1, slate);
        slate.add(input[idx]);
        subsetHelper(input, idx+1, slate);
        slate.remove(slate.size()-1);
    }
}
