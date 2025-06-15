import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m,a,b;
    static ArrayList<Integer>[] adj;
    static int [] know = new int[504];
    static int [] visited = new int[504];
    static int ret = 0;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        adj = new ArrayList[n+1];
        for(int i = 0; i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            adj[a].add(b);
        }
        
        for(int i = 1; i<=n;i++){
            bfs(i);
            Arrays.fill(visited, 0);
        }
        for(int i = 1;i<=n;i++){
            if(know[i] == n-1){
                ret++;
            }
        }
        System.out.print(ret);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int cnt = 0;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int next : adj[p]){
                if(visited[next] == 0){
                    cnt++;
                    know[next]++;
                    q.offer(next);
                    visited[next] = 1;
                }
            }
        }
        know[start] += cnt;
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
