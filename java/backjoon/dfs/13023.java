import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static ArrayList<Integer>[] adj;
    static int [] visited = new int[2004];
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        init();
        for(int i = 0; i<n;i++){
            visited[i] = 1;
            dfs(i);
            visited[i] = 0;
            if(ret == 1){
                break;
            }
        }
        System.out.print(ret);
    }
    
    static void dfs(int idx){
        if(visited[idx] == 5){
            ret = 1;
            return;
        }
        for(int next : adj[idx]){
            if(visited[next] == 0){
                visited[next] = visited[idx] + 1;
                dfs(next);
                visited[next] = 0;
            }
            if(ret == 1){
                return;
            }
        }
    }
    
    static void init() throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        adj = new ArrayList[n];
        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<m;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
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
