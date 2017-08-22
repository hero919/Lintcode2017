public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        this.next = null;
    }

    @Override
    public String toString() {
        ListNode node = this;
        String s = "";
        while(node != null) {
            s = s + node.val + "->";
            node = node.next;
        }
        return s;
    }
}
