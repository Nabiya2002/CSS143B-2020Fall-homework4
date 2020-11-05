package Problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(Collections.emptyList());
            return result;
        }

        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);

            result.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                permute(nums, index + 1, result);
                swap(nums, i, index);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
