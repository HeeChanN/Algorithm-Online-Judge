import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,q;
    static ArrayList<int[]>[] adj = new ArrayList[5004];
    static int [] dist = new int[5004];
    static int k;
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        q = fs.nextInt();
        
        for(int i = 0; i<5004;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0;i <n-1;i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            int r = fs.nextInt();
            
            adj[u].add(new int[]{v,r});
            adj[v].add(new int[] {u,r});
        }

        for(int i = 0; i<q;i++){
            k = fs.nextInt();
            int v = fs.nextInt();
            cnt = 0;
            Arrays.fill(dist, -1);
            bfs(v);
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    
    static void bfs(int node){
        Queue<int []> q = new ArrayDeque<>();
        dist[node]= 0;
        q.offer(new int[]{node, 1000000001});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int [] next : adj[cur[0]]){
                int pos = next[0];
                int d = next[1];
                if(dist[pos] != -1){
                    continue;
                }
                dist[pos] = Math.min(d, cur[1]);
                q.offer(new int[] {pos, dist[pos]});
                if(dist[pos] >= k){
                    cnt++;
                }
            }
        }
    } 
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
