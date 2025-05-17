import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 987654321;
        int l = 1;
        int r = 0;
        
        for(int diff : diffs){
            r = Math.max(diff,r);
        }
        
        while(l<=r){
            int level = l + (r-l)/2;
            long clear_time = 0L;
            for(int i = 0; i<diffs.length;i++){
                if(diffs[i]<=level){
                    clear_time = clear_time + times[i];
                }
                else{
                    clear_time = clear_time + times[i] + Math.abs(diffs[i]-level) * (times[i] + times[i-1]);
                }
            }
            if(clear_time <= limit){
                answer = Math.min(answer, level);
                r = level - 1;
            }
            else{
                l = level + 1;
            }
        }
        
        return answer;
    }
}
