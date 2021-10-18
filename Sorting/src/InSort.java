import java.util.Arrays;

public class InSort {
    public static void main(String[] args) {
        int A[] = {8, 13, 7, 10, 11, 1, 9, 4, 6, 5};

        insertionSortBottomUp(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    private static void insertionSortTopDown(int[] a, int length) {

        for(int i=0;i<length-1;i++){
            int max = a[i+1];
            int j = i+1;
            while(j>0 && a[j-1]>max){
                a[j] = a[j-1];
                j--;
            }
            a[j] = max;
        }
    }

    private static void insertionSortBottomUp(int[] a, int length) {

        for(int i=length-1;i>0;i--){
            int max = a[i-1];
            int j = i-1;
            while(j<length-1 && a[j+1]<max){
                a[j] = a[j+1];
                j++;
            }
            a[j] = max;
        }
    }
}