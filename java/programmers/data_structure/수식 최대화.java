import java.util.*;

class Solution {
    
    static Map<Character, Integer> match = Map.of(
        '+',0,
        '-',1,
        '*', 2
    );
    static int [][] prior ={
        {0,1,2},
        {0,2,1},
        {1,0,2},
        {1,2,0},
        {2,0,1},
        {2,1,0}
    };
    static Queue<Integer> op = new ArrayDeque<>();
    static Deque<Long> number = new ArrayDeque<>();
    
    public long solution(String expression) {
        long answer = 0;
        int idx = 0;
        for(int i = 0; i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                Long num = Long.parseLong(expression.substring(idx,i));
                number.offer(num);
                op.offer(match.get(expression.charAt(i)));
                idx = i+1;
            }
        }
        Long num = Long.parseLong(expression.substring(idx,expression.length()));
        number.offer(num);
        
        for(int i = 0; i<6;i++){
            Deque<Long> copy = new ArrayDeque<>(number);
            Queue<Integer> copyOp = new ArrayDeque<>(op);
            for(int j = 0; j<3;j++){
                int t = copyOp.size();
                for(int k = 0; k<t;k++){
                    Integer cur = copyOp.poll();
                    Long a = copy.poll();
                    if(cur == prior[i][j]){
                        Long b = copy.poll();
                        copy.offerFirst(calc(a,b,cur));
                    }
                    else{
                        copyOp.offer(cur);
                        copy.offer(a);
                    }
                }
                copy.offer(copy.poll());
            }
            long ret = copy.poll();
            answer = Math.max(answer, Math.abs(ret));
        }
        
        return answer;
    }
    
    static Long calc(Long a, Long b, int c){
        if (c == 0){
            return a + b;
        }
        else if (c == 1){
            return a - b;
        }
        else{
            return a * b;
        }
    }
}
