import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int A[] = {3, 10, 2, 9, 6, 5};

        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void bubbleSort(int[] a) {
        int temp=0;
        int n = a.length;

        for(int i=0;i<n-1;i++){
            for(int j=n-1;j>i;j--){
                if(a[j]<a[j-1]){
                    temp = a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }

    }
}