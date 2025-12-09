class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map = new HashMap<>();

        int idx = 1;
        ListNode cur = head;
        while(cur != null){
            map.put(idx++, cur);
            cur = cur.next;
        }
        int target = idx - n;
        ListNode deletedNode = map.get(target);
        if(target == 1){
            head = deletedNode.next;
        }
        else{
            ListNode prev = map.get(target-1);
            prev.next = deletedNode.next;
        }
        return head;
    }
}
