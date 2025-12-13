import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업 요청 시간이 따로 주어질 때 -> 정렬을 해줘야함
        
        Arrays.sort(jobs, Comparator.comparingInt((int [] a) -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int [] a) -> a[0])
                .thenComparingInt((int[] a) -> a[1])
                .thenComparingInt((int[] a) -> a[2])
        );
        
        int n = jobs.length;
        int time = 0;
        int done = 0;
        int idx = 0;
        
        while(done < n){
            // 대기큐 넣기
            while(idx < n && time >= jobs[idx][0]){
                pq.offer(new int[]{jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }
            
            // 대기큐 비어있으면 시간 점프
            if(pq.isEmpty()){
                time = jobs[idx][0];
                continue;
            }
            
            // 로직 처리
            int [] job = pq.poll();
            time += job[0];
            answer += time - job[1];
            done++;
        }        
        
        return answer/ n;
    }
}
