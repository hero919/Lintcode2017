public class Jul28 {
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode pre = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }



    public ListNode insert(ListNode node, int x) {
        if (node == null) {
            ListNode result = new ListNode(x);
            result.next = result;
            return result;
        }

        ListNode pre = node;
        ListNode n = node.next;

        while (n != node) {
            if (x >= pre.val && x <= n.val) {
                break;
            }

            if (x <= pre.val && x >= n.val) {
                pre = n;
                n = n.next;
                break;
            }
            pre = n;
            n = n.next;
        }

        ListNode newNode = new ListNode(x);
        pre.next = newNode;
        newNode.next = n;
        return pre;
    }













    public static void main(String[] args) {
        Jul28 j = new Jul28();
        System.out.println();


        System.out.println("Test");
    }
}
