import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int sampleArray[] = {11, 13, 12, 10, 14, 9, 16};

        int[] sortedArray = mergeSort(sampleArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] mergeSort(int[] a) {

        if(a.length==1){
            return a;
        }

        int mid = a.length/2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(a,0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(a, mid, a.length));

        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] l, int[] r) {
        int lLen = l.length;
        int rLen = r.length;
        int tempLen = 0;
        int[] tempArray = new int[lLen+rLen];
        int le=0;
        int rt=0;

        while(le<lLen && rt<rLen){
            if(l[le]>r[rt]) {
                tempArray[tempLen++] = r[rt];
                rt++;
            } else{
                    tempArray[tempLen++] = l[le];
                    le++;
            }
        }

        while(le<lLen){
           tempArray[tempLen++] = l[le++];
        }

        while(rt<rLen){
          tempArray[tempLen++] = r[rt++];
        }

        return tempArray;
    }
}