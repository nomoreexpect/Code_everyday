import java.util.HashMap;
import java.util.Map;

/**
 * @Author:PanYa
 * @Date 2024/5/27-上午9:24
 * @Description: Optimized LRU Cache implementation
 */
public class LRUCache_ {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> map;
    private int size;
    private int capacity;

    public LRUCache_(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }else {
            DLinkedNode node = map.get(key);
            refreshNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            addNode(node);
            map.put(key, node);
            if (++size > capacity) {
                DLinkedNode prevTail = tail.prev;
                removeNode(prevTail);
                map.remove(prevTail.key);
                size--;
            }
        }else {
            DLinkedNode node = map.get(key);
            node.value = value;
            refreshNode(node);
        }
    }

    private void addNode(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void refreshNode(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public static void main(String[] args) {
        LRUCache_ cache = new LRUCache_(2);

        // test put and get
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));

        //test LRU property
        cache.put(3, 3);
        System.out.println(cache.get(2));

        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
