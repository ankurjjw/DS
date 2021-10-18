import java.util.*;

public class MedianInStreamHeap2 {

    public static void main(String[] args) {
        List<Integer> onlineStream = new ArrayList<>(Arrays.asList(4,3,1,2));
        System.out.println(online_median(onlineStream));
    }

    // Complete the function below.
    public static List<Integer> online_median(List<Integer> stream) {

        List<Integer> medianList = new ArrayList<>();

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int temp = 0;
        int i=0;

        while(i<stream.size()) {
            System.out.println(maxQ+" "+minQ+" "+minQ.size()+maxQ.size());

            if(stream.get(i)>minQ.peek()){
                minQ.add(stream.get(i));
            }else{
                maxQ.add(stream.get((i)));
            }

            if(minQ.size()-maxQ.size()>1){
                temp = minQ.poll();
                maxQ.add(temp);
            } else if(maxQ.size()-minQ.size()>1){
                temp = maxQ.poll();
                minQ.add(temp);
            }

            if(minQ.size()+maxQ.size()%2==0){
                medianList.add((minQ.peek()+maxQ.peek()/2));

            }else {
                medianList.add(minQ.peek());
            }

            i++;

        }
        return medianList;

    }

}
