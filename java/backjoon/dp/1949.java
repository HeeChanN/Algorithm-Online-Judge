import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int a,b;
    static int[] town = new int[10004];
    static ArrayList<Integer>[] adj = new ArrayList[10004];
    static int[][] dp = new int[10004][2];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            town[i] = fs.nextInt();
        }
        for(int i = 1; i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i =0;i<n-1;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        go(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    static void go(int cur, int parent){
        dp[cur][0] = 0;
        dp[cur][1] = town[cur];
        for(int next : adj[cur]){
            if (next == parent) continue;
            go(next, cur);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
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
