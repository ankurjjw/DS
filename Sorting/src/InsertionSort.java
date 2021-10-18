import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int A[] = {11, 1, 9, 4, 6, 5};

        insertionSortTopDown(A, A.length);
        System.out.println(Arrays.toString(A));
    }


    private static void insertionSortBottomUp(int[] a, int n) {
        if(n<=1){
            return;
        }
        insertionSortBottomUp(a, n-1);
        int last = a[n-1];
        int j = n-1;

        while(j>0 && a[j-1] > last){
            a[j] = a[j-1];
            j--;
        }
        a[j] = last;
    }

    private static void insertionSortTopDown(int[] a, int n) {
        if(n==1){
            return;
        }

        int last = a[n-2];
        int j = n-2;

        while(j<a.length-1 && a[j+1] < last){
            a[j] = a[j+1];
            j++;
        }
        a[j] = last;

        insertionSortTopDown(a, n-1);
    }
}
