import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        String input = "a1b2";
        char[] charInput = input.toCharArray();

        String slate = "";

        letterCaseHelper(charInput, 0, slate);

        System.out.println(result);

    }

    private static void letterCaseHelper(char[] charInput, int idx, String slate) {

        if(idx==charInput.length){
            result.add(slate);
            return;
        }
        if(Character.isDigit(charInput[idx])){
            letterCaseHelper(charInput, idx+1, slate+charInput[idx]);
        } else{
            letterCaseHelper(charInput, idx+1, (slate+ Character.toLowerCase(charInput[idx])));
            letterCaseHelper(charInput, idx+1, (slate+ Character.toUpperCase(charInput[idx])));

        }
    }


}
