//https://www.acmicpc.net/problem/17845

import java.util.*;
import java.io.*;

class Main {
    
    static class Pair{
        int time;
        int w;
        
        public Pair(int time, int w){
            this.time = time;
            this.w = w;
        }
    }
    
    static FastScanner fs = new FastScanner();
    static int n,k;
    
    static Pair[] arr = new Pair[1004];
    static int[] dp = new int[10004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<k;i++){
            int w = fs.nextInt();
            int time = fs.nextInt();
            arr[i] = new Pair(time,w);
        }
        
        for(int idx = 0 ;idx<k;idx++){
            int t = arr[idx].time;
            int v = arr[idx].w;
            for(int i = n;i>=t;i--){
                dp[i] = Math.max(dp[i], dp[i-t] + v);
            }
        }
        
        System.out.print(dp[n]);
    }
    
    static class FastScanner{
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
