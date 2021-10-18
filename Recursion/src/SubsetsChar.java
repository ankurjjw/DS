import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsChar {
    public static List<String[]> result = new ArrayList<>();

    public static void main(String[] args) {
        String input = "xyz";
        List<String> slate = new ArrayList<>();

        subsetHelper(input, 0, slate);

        for(String[] arr: result){
            System.out.println(Arrays.toString(arr));
        }

    }

    private static void subsetHelper(String input, int idx, List<String> slate) {

        if(idx>=input.length()){
            result.add(slate.toArray(new String[0]));
            return;
        }
        subsetHelper(input, idx+1, slate);
        slate.add(input.substring(idx, idx+1));
        subsetHelper(input, idx+1, slate);
        slate.remove(slate.size()-1);


    }
}
