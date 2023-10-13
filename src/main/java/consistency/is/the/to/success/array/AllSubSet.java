package consistency.is.the.to.success.array;

import java.util.ArrayList;
import java.util.List;

public class AllSubSet {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        List<List<Integer>> allSubset = getAllSubset(array);
        System.out.println(allSubset);
    }

    private static List<List<Integer>> getAllSubset(int[] array) {
        List<List<Integer>> powerSet =new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getAllSubset(powerSet ,subset ,array ,0);
        return powerSet;
    }

    private static void getAllSubset(List<List<Integer>> powerSet, List<Integer> subset, int[] array, int i) {
        powerSet.add(new ArrayList<>(subset));
        for (int j = i; j < array.length; j++) {
            subset.add(array[j]);
            getAllSubset(powerSet, subset, array, j+1);
            subset.remove(subset.size() -1);
        }
    }
}
