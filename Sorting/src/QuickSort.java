import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int sampleArray[] = {11, 13, 12, 10, 14, 9, 16, 15, 2, 4, 3, 11};

        quickSort(sampleArray, 0, sampleArray.length-1);
        System.out.println(Arrays.toString(sampleArray));
    }

    private static void quickSort(int[] a, int start, int end) {

        if(start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        quickSort(a, 0, pivot-1);
        quickSort(a, pivot+1, end);
    }

    private static int partition(int[] a, int low, int high) {
        int mid = low + (high-low)/2;

        int piv = a[mid];
        swap(a,low,mid);

        int small = low;
        int large = low;

        for(large=low+1;large<=high;large++){
            if(a[large]<piv){
                small++;
                swap(a, small, large);
            }

        }
        swap(a,small,low);
        return small;
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}