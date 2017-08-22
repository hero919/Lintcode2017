import java.util.ArrayList;
import java.util.Arrays;

public class Aug07 {


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int left = nums[i];
            int right = nums[j];
            if (left + right == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }

            if (left + right < target) {
                i++;
            }else{
                j--;
            }
        }
        return result;
    }


//    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
//        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
//
//        if (nums == null || nums.length < 3) {
//            return results;
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            // skip duplicate triples with the same first numebr
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int left = i + 1, right = nums.length - 1;
//            int target = -nums[i];
//
//            twoSum(nums, left, right, target, results);
//        }
//
//        return results;
//    }
//
//    public void twoSum(int[] nums,
//                       int left,
//                       int right,
//                       int target,
//                       ArrayList<ArrayList<Integer>> results) {
//        while (left < right) {
//            if (nums[left] + nums[right] == target) {
//                ArrayList<Integer> triple = new ArrayList<>();
//                triple.add(-target);
//                triple.add(nums[left]);
//                triple.add(nums[right]);
//                results.add(triple);
//
//                left++;
//                right--;
//                // skip duplicate pairs with the same left
//                while (left < right && nums[left] == nums[left - 1]) {
//                    left++;
//                }
//                // skip duplicate pairs with the same right
//                while (left < right && nums[right] == nums[right + 1]) {
//                    right--;
//                }
//            } else if (nums[left] + nums[right] < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            solveTwoSum(numbers, i, left, right, 0 - numbers[i], result);
        }

        return result;
    }




    private void solveTwoSum(int[] numbers,int start, int left, int right, int target, ArrayList<ArrayList<Integer>> result) {
        if (numbers == null || numbers.length < 3) {
            return;
        }

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ArrayList<Integer> resultSet = new ArrayList<>();
                resultSet.add(numbers[start]);
                resultSet.add(numbers[left]);
                resultSet.add(numbers[right]);
                result.add(resultSet);

                left++;
                right--;
                while(left < right && numbers[left] == numbers[left - 1]){
                    left++;
                }
                while(left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }

            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                right--;
            }

        }
    }



    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            }else if (nums[i] == 1) {
                i++;
            }else{
                swap(nums, i, right);
                right--;
            }
        }
    }


    private void swap(int[] a, int i , int j){
        int tmp =  a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return target;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int difference = Integer.MAX_VALUE;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                difference = Math.min(difference, (target - (nums[left] + nums[right])));
                left++;
            }else {
                difference = Math.min(difference, ((nums[left] + nums[right]) - target));
                right--;
            }
        }
        return difference;
    }




    public static void main(String[] args) {
        System.out.println("Test");
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(2);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(a);
        System.out.println(result.contains(b));
        Aug07 aug = new Aug07();
        System.out.println(aug.threeSum(new int[]{
                -6, -5, -2, 8
    }));
    }
}
