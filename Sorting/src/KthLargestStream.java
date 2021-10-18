import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KthLargestStream {

    public static void main(String[] args) {

        List list1 = new ArrayList(Arrays.asList(1000000000));
        List list2 = new ArrayList(Arrays.asList(100000000));

        ArrayList<Integer> lis1 = new ArrayList<>();


        kth_largest(2,list1,list2);
    }


    public static void kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        // Write your code here
        for(int i=0;i<append_stream.size();i++){
            initial_stream.add(append_stream.get(i));
            quickSort(initial_stream, 0, initial_stream.size()-1, initial_stream.size()-k);
            System.out.println(initial_stream.get(initial_stream.size()-k));
        }

    }

    private static void quickSort(List<Integer> initial_stream, int start, int end, int index) {
        if(start<end){
            int pivotIndex = partition(initial_stream, start, end);

            if(pivotIndex==index){
                return;
            }else if(pivotIndex>index){
                quickSort(initial_stream, start, pivotIndex-1, index);
            }else {
                quickSort(initial_stream,pivotIndex+1, end, index);
            }
        }
    }

    private static int partition(List<Integer> initial_stream, int start, int end) {
        int low = start;
        Random random = new Random();

        int pivotIndex = random.nextInt(end - start) + start;

        int temp = initial_stream.get(pivotIndex);
        initial_stream.set(pivotIndex, initial_stream.get(low));
        initial_stream.set(low, temp);

        int pivot = initial_stream.get(low);
        int high=start+1;
        while(high<=end){
            if(initial_stream.get(high) <= pivot){
                low++;
                temp = initial_stream.get(high);
                initial_stream.set(high, initial_stream.get(low));
                initial_stream.set(low, temp);
            }
            high++;
        }
        temp=initial_stream.get(start);
        initial_stream.set(start, initial_stream.get(low));
        initial_stream.set(low, temp);
//        System.out.println(initial_stream);
        return low;
    }
}