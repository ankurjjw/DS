import java.util.*;

public class MedianInStreamHeap {

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
             System.out.println("1st median list " + medianList);

            if (minQ.isEmpty()) {
                minQ.add(stream.get(i));
                medianList.add(minQ.peek());
                i++;
            }

            if (i < stream.size()) {

                if (maxQ.isEmpty() && minQ.peek() < stream.get(i)) {
                    temp = minQ.poll();
                    maxQ.add(temp);
                    minQ.add(stream.get(i));
                    medianList.add((maxQ.peek() + minQ.peek()) / 2);
                    i++;
                } else if (maxQ.isEmpty() && minQ.peek() >= stream.get(i)) {
                    maxQ.add(stream.get(i));
                    medianList.add((maxQ.peek() + minQ.peek()) / 2);
                    i++;
                }
            }
    //            System.out.println("median list " + medianList);

    //            System.out.println(minQ);
    //            System.out.println(maxQ);

                 System.out.println(maxQ + " " + minQ);

                if(i<stream.size()){

                    if (minQ.size() < 2 && stream.get(i) > maxQ.peek() && stream.get(i) < minQ.peek()) {
                        minQ.offer(stream.get(i));
                    } else if (minQ.size() < 2 && stream.get(i) > minQ.peek()) {
                        minQ.offer(stream.get(i));
                    } else if (minQ.size() < 2 && stream.get(i) < maxQ.peek()) {
                        if (maxQ.size() >= 2) {
                            temp = maxQ.poll();
                            minQ.add(temp);
                        }
                        maxQ.offer(stream.get(i));

                    } else if (minQ.size() >= 2 && stream.get(i) > maxQ.peek() && stream.get(i) < minQ.peek()) {
                        if(minQ.size()>=2){
                            temp=minQ.poll();
                            maxQ.add(temp);
                        }
                        minQ.offer(stream.get(i));
                    } else if (minQ.size() >= 2 && stream.get(i) > maxQ.peek() && stream.get(i) > minQ.peek()) {
                        temp = minQ.poll();
                        maxQ.add(temp);
                        minQ.add(stream.get(i));
                    } else if (minQ.size() >= 2 && stream.get(i) < maxQ.peek()) {
                        //System.out.println("stream" + stream.get(i));
                        maxQ.offer(stream.get(i));
                    }
                     System.out.println(maxQ + " " + minQ + maxQ.peek()+minQ.peek());
                    i++;
                    if (i % 2 != 0 && minQ.size()>maxQ.size()) {
                        medianList.add(minQ.peek());
                    } else if (i % 2 != 0 && minQ.size()<maxQ.size()) {
                        medianList.add(maxQ.peek());
                    } else {
    //                System.out.println("maxQ.peek() " + maxQ.peek() + maxQ);
                        medianList.add((maxQ.peek() + minQ.peek()) / 2);
                    }

//            System.out.println(minQ);
//            System.out.println(maxQ);


            }
        }
//        System.out.println("median list " + medianList + " i" + i);
        return medianList;

    }

}
