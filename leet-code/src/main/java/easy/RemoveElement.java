package easy;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                int temp = nums[result];
                nums[result] = nums[i];
                nums[i] = temp;
                result++;
            }
        }

        return result;
    }
}
