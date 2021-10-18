import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int A[] = {3,1,2,4,6,5};

        selectionSort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void selectionSort(int[] a) {
        int temp;
        int n = a.length;
        for(int i=0;i<n;i++){
            int min_index=i;
            for(int j=i+1; j<n-1;j++){
                if(a[j]<a[min_index])
                    min_index=j;
            }
            temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
    }


//    private static void selectionSort(int[] a) {
//        int min = 0;
//        for(int i=0;i<a.length;i++){
//            for(int j=i;j<a.length;j++){
//                if(a[j]<a[i]){
//                    min = a[i];
//                    a[i] = a[j];
//                    a[j] = min;
//                }
//            }
//        }
//    }
}
