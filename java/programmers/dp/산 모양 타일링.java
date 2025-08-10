// https://school.programmers.co.kr/learn/courses/30/lessons/258705

class Solution {
    
    static int N;
    static int[] arr;
    static int [] dp;
    
    public int solution(int n, int[] tops) {
        N = 2 * n + 1;
        arr = new int[N + 1];
        dp = new int[N+1];
        
        for(int i = 0;i<n;i++){
            if(tops[i] == 1){
                arr[2 * i + 1] = 1;
            }
        }
        
        dp[N] = 1;
        dp[N-1] = 1;
        for(int i = N-2;i>=0;i--){
            if(i % 2== 1 && arr[i] == 1){
                int one = dp[i+1] * 2;
                int two = dp[i+2];
                dp[i] = (one + two) % 10007;
            }
            else{
                dp[i] = (dp[i+1] + dp[i+2]) % 10007;
            }
        }
        return dp[0] % 10007;
    }
}
