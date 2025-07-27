// https://www.acmicpc.net/problem/1943

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int a, b;
    static int [] coins = new int[104];
    static int [] cnt = new int[104];
    static int [] dp = new int[100004];
    
    public static void main(String[] args) throws Exception {
        for(int i = 0; i<3;i++){
            n = fs.nextInt();
            int sum = 0;
            for(int j = 0;j<n;j++){
                coins[j] = fs.nextInt();
                cnt[j] = fs.nextInt();
                sum += coins[j] * cnt[j];
            }
            if(sum % 2 == 1){
                sb.append("0\n");
                continue;
            }
            dp[0] = 1;
            for(int j =0;j<n;j++){
                int v = coins[j];
                int c = cnt[j];
                for(int k = 1; c > 0;k = k * 2){
                    int use = Math.min(c,k);
                    for(int idx = sum;idx >=use * v; idx--){
                        dp[idx] += dp[idx - (use*v)];
                    }
                    
                    c = c - use;
                }
            }
            
            if(dp[sum/2] == 0){
                sb.append("0\n");
            }
            else{
                sb.append("1\n");
            }
            clearArray();
        }
        System.out.print(sb);
    }
    
    static void clearArray(){
        Arrays.fill(coins, 0);
        Arrays.fill(cnt, 0);
        Arrays.fill(dp,0);
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
