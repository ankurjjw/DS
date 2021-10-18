public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] A = {0,1,2,3,4,5,6,7,8};
        int sum = 8;

        int leftPointer = 0;
        int rightPointer = A.length-1;

        while(leftPointer<rightPointer){
            int temp = A[leftPointer] + A[rightPointer];
            if(temp<sum){
                leftPointer++;
            } else if(temp>sum){
                rightPointer--;
            }else{
                System.out.println("Found: [" + A[leftPointer] + "," + A[rightPointer] + "]");
                leftPointer++;
                rightPointer--;
            }
        }

    }
}
