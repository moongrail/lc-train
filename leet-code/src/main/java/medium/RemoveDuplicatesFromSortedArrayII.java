package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates2(array));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> mapValues = new HashMap<>();

        for (int num : nums) {
            mapValues.put(num, mapValues.getOrDefault(num, 0) + 1);
        }

        nums = mapValues.entrySet()
                .stream()
                .flatMapToInt(entry -> IntStream.generate(entry::getKey)
                        .limit(Math.min(entry.getValue(), 2)))
                .toArray();

        return nums.length;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length < 3) return nums.length;
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            nums[j++] = nums[i++];
            if (i < nums.length && nums[i] == nums[j - 1])
                nums[j++] = nums[i++];
            while (i < nums.length && nums[i] == nums[j - 1]) i++;
        }

        return j;
    }
}
