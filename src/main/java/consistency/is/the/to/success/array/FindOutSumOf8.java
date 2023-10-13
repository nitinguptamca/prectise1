package consistency.is.the.to.success.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindOutSumOf8 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 4, 8, -1, 6, 9, 7};
        List<List<Integer>> powerSet = getAllSubset(array);
        Set<Set<Integer>> superSetOf8 = new HashSet<>();
        for (List<Integer> inner : powerSet) {
                int sum=inner.stream().reduce(0 ,(a,b) -> a+b);
                if(sum==8) superSetOf8.add(new HashSet<>(inner));
        }
        System.out.println(superSetOf8);
    }

    private static List<List<Integer>> getAllSubset(int[] array) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getAllSubset(powerSet, subset, array, 0);
        return powerSet;
    }

    private static void getAllSubset(List<List<Integer>> powerSet, List<Integer> subset, int[] array, int i) {
        powerSet.add(new ArrayList<>(subset));
        for (int j = i; j < array.length; j++) {
            subset.add(array[j]);
            getAllSubset(powerSet, subset, array, j + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
