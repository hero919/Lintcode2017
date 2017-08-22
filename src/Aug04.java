import javax.jnlp.IntegrationService;
import java.util.*;

public class Aug04 {


    public static class tracker{
        int index;
        int sum;
        tracker(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        List<tracker> list = new ArrayList<>();
        list.add(new tracker(0, 0));
        int totalSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            totalSum = totalSum + nums[i - 1];
            list.add(new tracker(i, totalSum));
        }

        class trackerComparator implements Comparator<tracker>{

            @Override
            public int compare(tracker o1, tracker o2) {
                if (o1.sum == o2.sum){
                    return o1.index - o2.index;
                }
                return o1.sum - o2.sum;
            }
        }

        Collections.sort(list, new trackerComparator());

        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i).sum - list.get(i + 1).sum) < difference) {
                difference = Math.abs(list.get(i).sum - list.get(i + 1).sum);
                result[0] = Math.min(list.get(i).index, list.get(i + 1).index);
                result[1] = Math.max(list.get(i).index, list.get(i + 1).index) - 1;
            }
        }



        return result;
    }


    private static ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode pre = null;
        ListNode head = node;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;

        while (node != null) {
            ListNode start = node;
            Boolean e = false;
            ListNode end;
            for (int i = 0; i < k; i++) {
                if (node == null || node.next == null) {
                    e = true;
                    break;
                }
                node = node.next;
            }
            if (!e) {
                end = node;
            }else{
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode begin = start.next;
            ListNode reversed = reverse(begin);
            start.next = reversed;
            begin.next = next;
            node = begin;
        }
        return dummyHead.next;
    }


    public class TwoSum {

        private Map<Integer, Integer> map = new HashMap<>();
        // Add the number to an internal data structure.
        public void add(int number) {
            // Write your code here
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
                return;
            }
            map.put(number, 1);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int value) {
            // Write your code here
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int a = e.getKey();
                int b = value - a;
                if ((map.containsKey(b) && (a != b)) || (e.getValue() >= 2 && a * 2 == value)) {
                    return true;
                }
            }
            return false;
        }
    }


    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            nums[index++] = nums[i];
            set.add(nums[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("Test");
        System.out.println(Arrays.toString(subarraySumClosest(new int[] {
                101,33,44,55,67,78,-101,33,-44,55,-67,78,-100,200,-1000,22,100,200,1000,22
        })));

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(l1);
        System.out.println(reverseKGroup(l1, 2));

    }
}
