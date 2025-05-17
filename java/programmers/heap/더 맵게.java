import java.util.*;
import java.io.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        for(int i = 0; i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        
        while(true){
            if(pq.size() == 1){
                if(pq.peek() < K){
                    answer = -1;
                }
                break;
            }
            if(pq.peek() >= K){
                break;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b*2);
        }
        
        return answer;
    }
}
