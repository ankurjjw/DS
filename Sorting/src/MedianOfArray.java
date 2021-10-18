import java.util.Arrays;
import java.util.Random;

public class MedianOfArray {
    public static void main(String[] args) {
        int[] kArray = new int[]{1, 5, 4, 2, 3, 7, 6,2};
        int arrayLength = kArray.length;
        int k = arrayLength/2;
        int index;
        quickSort(kArray, 0, arrayLength-1, k);
        System.out.println(Arrays.toString(kArray));
        System.out.println(kArray[k]);
        quickSort(kArray, 0, k-1, k-1);
        System.out.println(Arrays.toString(kArray));
        System.out.println(kArray[k-1]);
    }

    private static void quickSort(int[] kArray, int start, int end, int index) {


        if(start<end) {

            int pivotIndex = partition(kArray, start, end);
            System.out.println("pivot index " + pivotIndex + " index " + index + " Array " + Arrays.toString(kArray));

            if (pivotIndex == index) {
                return;
            } else if (pivotIndex < index) {
                quickSort(kArray, pivotIndex + 1, kArray.length - 1, index);
            } else {
                quickSort(kArray, 0, pivotIndex - 1, index);

            }
        }
    }

    private static int partition(int[] kArray,int start, int end) {
        int low = start;
        Random random = new Random();

        int pivotIndex = random.nextInt(end - start) + start;

        int temp = kArray[pivotIndex];
        kArray[pivotIndex] = kArray[low];
        kArray[low] = temp;

        int pivot = kArray[low];

        int high=start+1;
        while(high<=end){
            if(kArray[high] <= pivot){
                low++;
                temp = kArray[high];
                kArray[high] = kArray[low];
                kArray[low] = temp;
            }
            high++;
        }
        temp=kArray[start];
        kArray[start]=kArray[low];
        kArray[low] = temp;

        return low;
    }
}
