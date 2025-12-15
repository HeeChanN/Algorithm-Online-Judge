public class Solution {
    public boolean hasCycle(ListNode head) {
        int [] visited = new int[10004];
        boolean flag = false;
        while(true){
            ListNode cur = head;
            if(cur == null){
                flag = false;
                break;
            }
            //System.out.println(cur.val);
            
            if(cur.val == 100001){
                flag = true;
                break;
            }
            cur.val = 100001;
            head = head.next;
        }
        return flag;
    }
}
