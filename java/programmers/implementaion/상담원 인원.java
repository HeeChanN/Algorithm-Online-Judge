import java.util.*;

class Solution {
    
    static int [][] consults;
    static int[] type;
    static int mento;
    static int answer = Integer.MAX_VALUE;
    
    static PriorityQueue<Integer> [] pq = new PriorityQueue[6];
    
    public int solution(int k, int n, int[][] reqs) {
        init(k,n,reqs);
        go(1,mento);
        
        return answer;
    }
    
    static int logic(){
        int waitTime = 0;
        for(int i =1;i<type.length;i++){
            pq[i] = new PriorityQueue<>();
        }
        
        for(int[] consult : consults){
            int start = consult[0];
            int time = consult[1];
            int id = consult[2];
            if(pq[id].size() < type[id]){
                pq[id].offer(start + time);
            }
            else{
                int endTime = pq[id].poll();
                if(start<endTime){
                    waitTime += endTime - start;
                    pq[id].offer(endTime + time);
                }
                else{
                    pq[id].offer(start + time);
                }
            }
        }
        return waitTime;
    }
    
    static void go(int idx, int left){
        if(idx == type.length){
            answer = Math.min(answer,logic());
            return;
        }
        for(int i = 0; i<=left;i++){
            type[idx] += i;
            go(idx+1,left-i);
            type[idx] -=i;
        }
    }
    
    static void init(int k,int n, int [][] reqs){
        consults = reqs;
        type = new int[k+1];
        Arrays.fill(type,1);
        mento = n - k;
    }
}
