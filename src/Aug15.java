public class Aug15 {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }

        int size = hashTable.length * 2;
        ListNode[] newTable = new ListNode[size];


        for (ListNode node : hashTable) {
            if (node == null) {
                continue;
            }


            while(node != null) {
                int val = node.val;

                int newPosition = (val % size + size) % size;

                if(newTable[newPosition] == null) {
                    ListNode newNode = new ListNode(val);
                    newTable[newPosition] = newNode;
                    node = node.next;
                    continue;
                }

                ListNode nodeInPosition = newTable[newPosition];
                while(nodeInPosition.next != null) {
                    nodeInPosition = nodeInPosition.next;
                }
                nodeInPosition.next = new ListNode(val);
                node = node.next;
            }
        }

        return newTable;

    }
}
