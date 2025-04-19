class Solution {
    
    static long l;
    static long r;
    static long m;
    
    public long solution(int n, int[] times) {
        long answer = 1000000000000000000L;
        m = times[0];
        for(int i = 1; i<times.length;i++){
            if(m <times[i]){
                m = times[i];
            }
        }
        l = 1;
        r = m * n;
        
        while(l <= r){
            long mid = l + (r-l)/2;
            long cnt = 0;
            for(int i = 0; i<times.length;i++){
                cnt = cnt + mid/times[i];
            }
            if(cnt >= n){
                if(answer > mid){
                    answer = mid;
                }
                r= mid-1;
            }
            else{
                l = mid+1;
            }
        }
        
        return answer;
    }
}