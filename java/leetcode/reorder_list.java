// 노드의 개수 = 5만개
// 절반까지 연결해 주고
// 다음 절반부터는 stack 쌓기
// 연결된 노드를 순회하며 stack.pop해서 중간 연결해주기
// 1. 연결리스트의 size 구하기
// 2. size가 짝수면 size 절반까지, size가 홀수면 size 절반 + 1까지만 연결리스트 미리 연결하기
// 3. 나머지 스택에 쌓기
// 4. 2번 연결리스트 중간 중간에 스택에서 꺼내 연결해주기
class Solution {
    public void reorderList(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while(cur != null){
            cnt++;
            cur = cur.next;
        }
        if(cnt == 1 || cnt == 2){
            return ;
        }

        // 2. 절반까지 포인터 옮기기
        ListNode middle = head;
        ListNode front = head;
        int len = cnt % 2 == 0 ? cnt / 2 : cnt / 2 + 1;
        int j = 1;
        while(j < len){
            middle = middle.next;
            j++;
        }
        ListNode right = middle.next;
        middle.next = null;
        System.out.print(len + " " + right.val);
        
        
        //3. stack에 담기
        Deque<ListNode> stack = new ArrayDeque<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }

        // 연결 맺기
        for(int i = len; i < cnt; i++){
            ListNode tmp = front.next;
            ListNode rightTmp = stack.pop();
            front.next = rightTmp;
            rightTmp.next = tmp;
            front = tmp;
        }
    }
}
