package src;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 */
public class LeetCode146 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size = 0;
    private int capacity = 0;
    private DLinkedNode head,tail;

    public LeetCode146(int capacity) {
        this.size=0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            addToHead(newNode);
            cache.put(key,newNode);
            size++;
            if (size>capacity){
                DLinkedNode tail = remove();
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev =head;
        node.next = head.next;
        head.next.prev = node;
        head.next=node;
    }

    private void removeToNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeToNode(node);
        addToHead(node);
    }
    private DLinkedNode remove(){
        DLinkedNode res = tail.prev;
        removeToNode(res);
        return res;
    }
}
