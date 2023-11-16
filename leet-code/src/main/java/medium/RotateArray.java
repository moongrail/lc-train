package medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
    }

    public static void rotate2(int[] nums, int k) {
        int indexRotate = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[indexRotate];
            nums[indexRotate] = temp;
            indexRotate++;
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length < 2) return;

        int rotations = k % nums.length;

        int[] subArray = new int[rotations];
        for (int i = nums.length - rotations, j = 0; i < nums.length; i++, j++) {
            subArray[j] = nums[i];
        }

        System.arraycopy(nums, 0, nums, rotations, nums.length - rotations);
        System.arraycopy(subArray, 0, nums, 0, rotations);
    }
}
