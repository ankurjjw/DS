import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationMutable {
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        String input = "abcd";
        char[] charInput = input.toCharArray();

        char[] slate = new char[input.length()];

        letterCaseHelper(charInput, 0, slate);

        System.out.println(result);

    }

    private static void letterCaseHelper(char[] charInput, int idx, char[] slate) {

        if(idx==charInput.length){
            result.add(new String(slate));
            return;
        }
        if(Character.isDigit(charInput[idx])){
            slate[idx] = charInput[idx];
            letterCaseHelper(charInput, idx+1, slate);
        } else{
            slate[idx] = Character.toLowerCase(charInput[idx]);
            letterCaseHelper(charInput, idx+1, slate);
            slate[idx] = Character.toUpperCase(charInput[idx]);
            letterCaseHelper(charInput, idx+1, slate);

        }
    }


}
