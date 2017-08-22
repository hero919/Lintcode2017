import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Jul27 {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        List<Integer> subset = new ArrayList<>();
        combinationSum2Helper(num, result, subset, target, 0);
        return result;
    }

   private void combinationSum2Helper(int[] num, List<List<Integer>> result, List<Integer> subset, int left, int index) {
        if (left == 0 && !result.contains(subset)) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (left < 0) {
            return;
        }

        for (int i = index; i < num.length; i++) {
            subset.add(num[i]);
            combinationSum2Helper(num, result, subset, left - num[i], i + 1);
            subset.remove(subset.size() - 1);
        }

   }



    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        permuteHelper(nums, result, subset);
        return result;
    }


    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> subset) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subset.contains(nums[i])){
                continue;
            }
            subset.add(nums[i]);
            permuteHelper(nums, result, subset);
            subset.remove(subset.size() - 1);
        }
    }


    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> subset = new ArrayList<>();
        partitionHelper(s, result, subset, 0);
        return result;


    }


    private void partitionHelper(String s, List<List<String>> result, List<String> subset, int startPosition) {
        if (startPosition == s.length()) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = startPosition; i < s.length(); i++) {
            if (isPalindrome(s.substring(startPosition, i + 1))) {
                subset.add(s.substring(startPosition, i + 1));
                partitionHelper(s, result, subset, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }



    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        for(int index = 0; index < s.length()/2 ; index++) {
            if (s.charAt(index) != s.charAt(s.length() - index - 1)) {
                return false;
            }
        }
        return true;
    }



    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        return null;

    }

    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            return new ListNode(x);
        }

        if (node.next == null) {
            node.next = new ListNode(x);
            return node;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = node;
        ListNode head = dummyHead.next;
        while (head.next != null) {
            if (head.val < x && head.next.val > x) {
                break;
            }
        }

        ListNode next = head.next;
        head.next = new ListNode(x);
        head = head.next;
        head.next = next;
        return dummyHead.next;
    }



    public static void main(String[] args) {
        Jul27 j = new Jul27();
//        System.out.println(j.combinationSum2(new int[]{
//                10,1,6,7,2,1,5
//        }, 8));
        System.out.println(j.permute(new int[]{
                1,2,3
        }));

        System.out.println(j.isPalindrome("abba"));
        System.out.println(j.partition("aab"));
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l33 = new ListNode(3);
        ListNode l55 = new ListNode(5);
        ListNode l11 = new ListNode(1);

        l33.next = l55;
        l55.next = l11;

        System.out.println(l33);
        System.out.println(j.insert(l11, 4));


    }



}
