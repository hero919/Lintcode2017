import java.util.HashMap;

public class LRUCache {

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> hs = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);


    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!hs.containsKey(key)) {
            return -1;
        }

        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        move_to_tail(current);

        return current.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }
        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        Node pre = tail.prev;
        pre.next = current;
        current.prev = pre;
        tail.prev = current;
        current.next = tail;
    }


}
