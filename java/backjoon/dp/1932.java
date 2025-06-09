import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] arr = new int[130000];
    static int [] dp = new int[130000]; 
    static int a = 0;
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            while(cnt < i){
                arr[a] = fs.nextInt();
                a++;
                cnt++;
            }
            cnt = 0;
        }
        System.out.println(go(0,1) + arr[0]);
    }
    
    static int go(int idx, int depth){
        if(depth == n){
            return 0;
        }
        if(dp[idx + depth] != 0){
            return dp[idx + depth];
        }
        int left = go(idx + depth, depth+1) + arr[idx+depth];
        int right = go(idx + depth + 1, depth + 1) + arr[idx + depth+1];
        
        dp[idx + depth] = Math.max(left, right);
        return dp[idx + depth];
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
