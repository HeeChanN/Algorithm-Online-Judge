import java.util.*;

class Solution {
    
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> a[0]));
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        for(int [] route : routes){
            pq.offer(new int[]{route[1],route[0]});
        }
        
        int [] pos = pq.poll();
        int end = pos[0];
        while(!pq.isEmpty()){
            pos = pq.poll();
            if(pos[1] <= end){
                continue;
            }
            answer++;
            end = pos[0];
        }
        answer++;
        return answer;
    }
}
