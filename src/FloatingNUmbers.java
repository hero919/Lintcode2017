import java.util.Arrays;
import java.util.Comparator;

public class FloatingNUmbers {


    public static int[] getNearlyArrayWithSameSum(double[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] intResult = new int[arr.length];
        NumDiff[] nums = new NumDiff[arr.length];
        int floorSum = 0;
        double arrSum = 0.0;
        int i = 0;
        for (double d : arr) {
            intResult[i] = (int) d;
            floorSum += intResult[i];
            arrSum += d;
            double diff = d - intResult[i];
            NumDiff n = new NumDiff(intResult[i], diff);
            nums[i] = n;
            i++;
        }
        int difference = (int)(arrSum - floorSum);
        Arrays.sort(nums, new Comparator<NumDiff>() {
            @Override
            public int compare(NumDiff o1, NumDiff o2) {
                if (o1.diff - o2.diff > 0) {
                    return -1;
                }
                return 1;
            }
        });

        for (int j = 0; j < difference; j++) {
            nums[j].floatedNum++;
        }

        int[] result = new int[arr.length];
        int index = 0;
        for (NumDiff n : nums) {
            result[index++] = n.floatedNum;
        }
        return result;
    }


    static class NumDiff {
        int floatedNum;
        double diff;
        NumDiff(int floatedNum, double diff) {
            this.floatedNum = floatedNum;
            this.diff = diff;
        }
    }








    public static void main(String[] args) {
        double[] arr = { 1.2, 3.7, 2.3, 4.8 };
        int[] res = getNearlyArrayWithSameSum(arr);
        for (int i : res) System.out.print(i + " ");
        System.out.println("Test");
    }



}
