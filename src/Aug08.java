import java.util.Arrays;

public class Aug08 {

    public int twoSum5(int[] nums, int target) {
        // Write your code here
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            }else{
                result = result + (right - left);
                left++;
            }
        }
        return result;
    }




    public static void main(String[] args) {
        System.out.println("Test");
    }
}
