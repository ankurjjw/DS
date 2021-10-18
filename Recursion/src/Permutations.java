import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<Integer[]> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<Integer> slateInt = new ArrayList<>();

        permutationHelper(input, 0, slateInt);

        for(Integer[] arr: result){
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void permutationHelper(int[] input, int idx, List<Integer> slate) {
        int temp;
        if(idx>=input.length){
            result.add(slate.toArray(new Integer[0]));
            return;
        }

        for(int i=idx; i<input.length;i++){

            swap(input, i, idx);
            slate.add(input[idx]);
            permutationHelper(input, idx+1, slate);
            slate.remove(slate.size()-1);
            swap(input, i, idx);
        }

    }

    public static void swap(int[] a1, int i, int j){
        int temp = 0;
        temp = a1[i];
        a1[i] = a1[j];
        a1[j] = temp;

    }
}
