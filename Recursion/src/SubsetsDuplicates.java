import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsDuplicates {
    public static List<Integer[]> result = new ArrayList<>();
    public static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {1,1,3};
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
        int count = 0;

        slate.add(input[idx]);
        subsetHelper(input, idx+1, slate);
        slate.remove(slate.size()-1);
        while(idx<input.length-1 && input[idx] == input[idx+1]){
            idx++;
        }
        subsetHelper(input, idx + 1, slate);



//        for(int j=idx;j<input.length;j++){
//            if(input[j]!=input[idx]){
//                break;
//            }
//            count++;
//        }


//        for(int i=1;i<=count;i++) {
//            slate.add(input[idx]);
//            subsetHelper(input, idx+i, slate);
//        }
//
//        for (int i=1;i<=count;i++){
//            slate.remove(slate.size()-1);
//        }
    }
}
