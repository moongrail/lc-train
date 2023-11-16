package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(array));
    }

    public static int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> mapNums = new HashMap<>();

        for (int num : nums) {
            mapNums.put(num, mapNums.getOrDefault(num, 0) + 1);
        }

        int size = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry : mapNums.entrySet()) {
            if (entry.getValue() > size) {
                return entry.getKey();
            }
        }

        return 0;
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }
}
