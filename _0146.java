import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _0146 {
//    LRU Cache

    /**
     * holy crap
     * tried everything, never thought about linked list
     * or linked hash map
     */
    class LRUCache {

        class Node {
            Node pre;
            Node next;
            int key;
            int val;

            public Node() {
                this.pre = null;
                this.next = null;
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.pre = null;
                this.next = null;
            }
        }

        Node head = new Node();
        Node tail = new Node();
        int capacity;
        int count = 0;
        HashMap<Integer, Node> hashMap = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node current = hashMap.get(key);
            if (current == null) {
                return -1;
            }
            moveToTail(current);
            return current.val;
        }

        public void put(int key, int value) {
            Node current = hashMap.get(key);
            if (current != null) {
                current.val = value;
                moveToTail(current);
                return;
            }
            current = new Node(key, value);
            insertIntoTail(current);
            hashMap.put(key, current);
            if (count != capacity) {
                count++;
            } else {
                removeFromHead();
            }
        }

        public void insertIntoTail(Node node) {
            node.pre = tail.pre;
            node.pre.next = node;
            node.next = tail;
            tail.pre = node;
        }

        public void moveToTail(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            insertIntoTail(node);
        }

        public void removeFromHead() {
            Node node = head.next;
            head.next = node.next;
            node.next.pre = head;
            hashMap.remove(node.key);
        }
    }
}
