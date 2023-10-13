package consistency.is.the.to.success.array;

public class GetSecondHeight {
    public static void main(String[] args) {
        int[] array = {1,99,90,4,2,9,3,11,72,92,80,93};
        int max1=0;
        int max2=0;
        for (int i = 1; i < array.length; i++) {
            max1= Math.max(max1,array[i]);
            max2 = Math.min(max1, array[i]);
        }
        System.out.println(max2 +"  "+max1);
    }
}
