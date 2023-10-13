package consistency.is.the.to.success.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] array1= {1,3,5,7,19,34,50};
        int[] array2={2,4,6,8,10};
        int[] margeArray = mergeSortArray(array1, array2);
        System.out.println(Arrays.toString(margeArray));
    }

    private static int[] mergeSortArray(int[] array1, int[] array2) {
        int[] out = new int[array1.length+ array2.length];
        int i=0,j=0, count=0 ,k= out.length;
        for ( ; i<array1.length && j< array2.length ; ) {
            int min =Math.min(array1[i],array2[j] );
            if(min==array1[i]) i++;
            else j++;
            out[count++]=min;
        }
        for (int l = i; l < array1.length; l++) out[count++]=array1[l];
        for (int l = j; l < array2.length; l++) out[count++] =array2[l];
        return out;
    }
}
