class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long left = 0;
        long right = 900000000000000L;
        long answer = right;
        
        while(left <= right){
            long mid = left + (right-left)/2;
            long gSum = 0, sSum = 0, tSum = 0;
            
            for(int i = 0;i<g.length;i++){
                long time = t[i];
                long roundTime = time * 2;
                long trips = mid / roundTime;
                if(mid % roundTime >= time){
                    trips++;
                }
                
                long c = trips * w[i];
                
                long gP = Math.min(g[i], c);
                long sP = Math.min(s[i], c);
                long tP = Math.min((long) g[i] + s[i], c);
                
                gSum += gP;
                sSum += sP;
                tSum += tP;
            }
            if(gSum >= a && sSum >=b && tSum >= (long) a + b){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return answer;
    }
}
