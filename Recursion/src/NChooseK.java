import java.util.ArrayList;
import java.util.List;

public class NChooseK {
    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        List<Integer> slate = new ArrayList<Integer>();
        subsetHelper(input, 0, slate, 1);
        System.out.println(result);
    }

    public static void subsetHelper(int[] input, int idx, List<Integer> slate, int k) {

        if (slate.size() == k) {
            result.add(List.copyOf(slate));
            return;
        }


        if (idx >= input.length) {
            //result.add(slate);
            return;
        }

        subsetHelper(input, idx + 1, slate, k);
        slate.add(input[idx]);
        subsetHelper(input, idx + 1, slate, k);
        slate.remove(slate.size() - 1);
    }
}
