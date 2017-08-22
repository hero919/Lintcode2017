import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aug01 {
    public static int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int startFromPre = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            startFromPre = startFromPre + i;
            if (startFromPre < i) {
                startFromPre = i;
            }
            maxValue = Integer.max(maxValue,Integer.max(i, startFromPre));
        }
        return maxValue;
    }


    public static ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int cumulative = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulative = cumulative + nums[i];
            //System.out.print(cumulative + "&&");
            if (cumulative == 0) {
                result.add(0);
                result.add(i);
                return result;
            }

            if (map.containsKey(cumulative)) {
                map.get(cumulative).add(i);
                continue;
            }
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            map.put(cumulative, newList);
        }
//        System.out.println();


//        for (Map.Entry e : map.entrySet()) {
//            System.out.print(e.getKey() + "  ");
//            System.out.print("[");
//            for (int i : (List<Integer>)e.getValue()) {
//                System.out.print(i);
//            }
//            System.out.print("]");
//            System.out.println();
//        }


        for (List<Integer> list : map.values()) {
            if (list.size() >= 2) {
                result.add(list.get(0) + 1);
                result.add(list.get(1));

            }
        }
        return result;
    }


    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyhead = new ListNode(0);
        ListNode node = dummyhead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
                continue;
            }

            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }

        if (l1 == null) {
            node.next = l2;
        }

        if (l2 == null) {
            node.next = l1;
        }

        return dummyhead.next;
    }


    private static ListNode getMedian(ListNode node) {
        if (node == null) {
            return null;
        }

        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode sortList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode temp = getMedian(node);
        ListNode right = temp.next;
        temp.next = null;
        ListNode left = node;
        ListNode l = sortList(left);
        ListNode r = sortList(right);
        return mergeTwoList(l, r);
    }


    // 给出[-3, 1, 1, -3, 5]，返回[0, 2]，[1, 3]， [1, 1]， [2, 2] 或者 [0, 4]。

    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int closestNumber = Integer.MIN_VALUE;



        return null;
    }








    public static void main(String[] args) {
        Aug01 a = new Aug01();
//        System.out.println(maxSubArray(new int[]{
//                -2, 2, -3, 4, -1, 2, 1, -5, 3
//        }));

        System.out.println(subarraySum(new int[]{
                -5,10,5,-3,1,1,1,-2,3,-4
        }));
    }
}
