import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestStreamHeap {

    public static void main(String[] args) {

        List list1 = new ArrayList(Arrays.asList(1000000000));
        List list2 = new ArrayList(Arrays.asList(100000000));


        kth_largest(2,list1,list2);
    }


    public static void kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<initial_stream.size();i++){
            if(minHeap.size()<k){
                minHeap.add(initial_stream.get(i));
            }else if(minHeap.peek()<initial_stream.get(i)){
                minHeap.poll();
                minHeap.add(initial_stream.get(i));
            }

        }
        // Write your code here
        for(int i=0;i<append_stream.size();i++){
            if (minHeap.size() >= k && minHeap.peek()<append_stream.get(i)) {
                minHeap.poll();
                minHeap.add(append_stream.get(i));

            } else if(minHeap.size()<k){
                minHeap.add(append_stream.get(i));
            }
            System.out.println(minHeap);
            System.out.println(minHeap.peek());

        }

    }


}