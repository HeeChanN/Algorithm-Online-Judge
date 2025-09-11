class Solution {
    
    static int [] lr = new int[600001];
    static long sum = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 987654321;
        int n = queue1.length + queue2.length;
        int idx = 0;
        for(int i = 0; i<queue1.length;i++){
            sum += (long)queue1[i] + queue2[i];
            lr[idx] = queue1[i];
            idx++;
        }
        for(int i = 0; i<queue1.length;i++){
            lr[idx] = queue2[i];
            idx++;
        }
        
        int l = 0; 
        int r = 0;
        long t = lr[0];
        while(l != n){
            if(t < sum/2){
                r= (r+1)%n;
                t += (long) lr[r];
            }
            else if ( t > sum/2){
                t-= (long) lr[l];
                l++;
            }
            else{
                int time = 987654321;
                if(l >= n/2 && r == n-1){
                    answer = Math.min(answer, l - n/2);
                }
                else if(l < n/2 && r < n/2){
                    time = l + r + n - r - 1;
                }
                else if ( l < n/2 && r >= n/2){
                    time = l + r - n/2 + 1;
                }
                else if (l>=n/2 && r >= n/2){
                    time = l + r - n/2 + 1;
                }
                else if (l>= n/2 && r < n/2){
                    time = l - n/2 + r+1;
                }
                answer = Math.min(answer, time);
                r= (r+1)%n;
                t+= (long) lr[r];
            } 
        }
        
        if(answer == 987654321){
            answer = -1;
        }
        
        return answer;
    }
}
