import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n;
    static ArrayList<Integer>[] adj = new ArrayList[504];
    static int []dp = new int[504];
    static int [] times = new int[504];
    
    
    public static void main(String[] args) throws Exception{
        init();
        for(int i = 1;i<=n;i++){
            sb.append(go(i)).append("\n");
        }
        System.out.print(sb);
    }
    
    static int go(int idx){
        if(dp[idx] != 0){
            return dp[idx];
        }
        for(int next : adj[idx]){
            dp[idx] = Math.max(dp[idx], go(next));
        }
        dp[idx] += times[idx];
        return dp[idx];
    }
    
    static void init() throws Exception{
        n = fs.nextInt();
        for(int i =1;i<=n;i++){
            adj[i] = new ArrayList<>();
            times[i] = fs.nextInt();
            int post;
            while(true){
                post = fs.nextInt();
                if(post == -1){
                    break;
                }
                adj[i].add(post);
            }
        }
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
