import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,m;
    static int[]dp = new int[1004];
    static ArrayList<Integer> adj[] = new ArrayList[1004];
    static int [] child = new int[1004];
    static Queue<Integer> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<1004;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
            child[b]++;
        }
        
        for(int i = 1;i<=n;i++){
            if(child[i] == 0){
                q.offer(i);
                dp[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                child[next]--;
                if(child[next] == 0){
                    dp[next] = dp[cur]+1;
                    q.offer(next);
                }
            }
        }
        for(int i = 1; i<=n;i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.print(sb);
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
