import java.util.ArrayList;
import java.util.List;

public class subsetDupChar {

    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {

        char[] input = {'b','a', 'c'};

        List<String> slate = new ArrayList<String>();

        combinationHelper(input,0,slate);

        System.out.println(results);

    }

    static void combinationHelper(char[] input, int idx, List slate){
        if(idx==input.length){
            results.add(String.join("",slate));
            return;
        }

        slate.add(String.valueOf(input[idx]));
        combinationHelper(input, idx+1, slate);
        slate.remove(slate.size()-1);

        while(idx<input.length-1 && input[idx] == input[idx+1]){
            idx++;
        }

        combinationHelper(input, idx+1, slate);


    }
}
