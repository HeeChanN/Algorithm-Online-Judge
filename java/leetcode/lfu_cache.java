import java.util.*;

class LFUCache {

    public static class Node{
        int key;
        int value;
        int cnt;
        Node prev;
        Node next;

        public Node(int key, int value, int cnt, Node prev, Node next){
            this.key = key;
            this.value = value;
            this.cnt = cnt;
            this.prev = prev;
            this.next = next;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head  = new Node(0, 0, 0, null, null);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        node.cnt += 1;
        reorder(node);
        //print();
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            node.cnt += 1;
        }
        else{
            if(map.size() == capacity){
                Node target = head.next;
                map.remove(target.key);
                head.next = target.next;
                if(target.next != null){
                    target.next.prev = head;
                }
                target.next = null;
                target.prev = null;
            }
            node = new Node(key, value,1,null,null);
            map.put(key, node);
            node.next = head.next;
            node.prev = head;
            if(node.next != null){
                head.next.prev = node;
            }
            head.next = node;
        }
        reorder(node);
        //print();
    }

    private void reorder(Node cur) {
    
        Node p = cur;
        while (p.next != null && cur.cnt >= p.next.cnt) {
            p = p.next;
        }

        // 이미 제자리면 끝
        if (p == cur) {
            return;
        }
        Node left = cur.prev;
        Node right = cur.next;

        left.next = right;
        if (right != null) {
            right.prev = left;
        }
        Node after = p.next;

        p.next = cur;
        cur.prev = p;

        cur.next = after;
        if (after != null) {
            after.prev = cur;
        }
    }

    public void print(){
        System.out.println("---print---");
        Node tmp = head.next;
        while(tmp != null){
            System.out.println(tmp.value + " " + tmp.cnt);
            tmp = tmp.next;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
