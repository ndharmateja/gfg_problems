package google.linkedlists;

import java.util.HashMap;

public class LRUCache {
    private static class DLLNode {
        private int key;
        private int value;
        private DLLNode prev;
        private DLLNode next;

        private DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 0;
    private DLLNode head;
    private DLLNode tail;
    private int capacity;
    private HashMap<Integer, DLLNode> map;

    // All the nodes will be stored as a doubly linked list
    // with most recently used at head
    // and least recently used at tail
    public LRUCache(int cap) {
        // Sentinel nodes
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;

        capacity = cap;
        map = new HashMap<>();
    }

    // O(1) time
    // Function to return value corresponding to the key.
    public int get(int key) {
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);

            // Delete the node and move it to head
            // as it is most recently used now
            deleteNode(node);
            insertNodeAtHead(node);

            // return value
            return node.value;
        }
        return -1;
    }

    private void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeAtHead(DLLNode node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    // O(1) time
    // Function for storing key-value pair.
    public void set(int key, int value) {
        // If key is already there
        // then update its value and move the node to the head
        // as it is the most recently used item now
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);
            node.value = value;

            // Remove node from list
            deleteNode(node);

            // Insert node at head
            insertNodeAtHead(node);
            return;
        }

        // Create the new node and put in map
        // and insert it at head
        DLLNode newNode = new DLLNode(key, value);
        map.put(key, newNode);
        insertNodeAtHead(newNode);
        size++;

        // If capacity is exceeded
        // remove the least recently used node
        if (size > capacity) {
            // Delete node and remove its key from map
            DLLNode toDelete = tail.prev;
            deleteNode(toDelete);
            map.remove(toDelete.key);
            size--;
        }
    }
}
