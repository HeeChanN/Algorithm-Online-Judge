import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,t,node;
    static int ret = 0;
    static ArrayList<Integer>[] adj = new ArrayList[10004];
    static int [] possible = new int[10004];
    static int [] time = new int[10004];
    static int [] dist = new int[10004];
    
    public static void main(String[] args) throws Exception{
        for(int i = 0;i<10004;i++){
            adj[i] = new ArrayList<>();
        }
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            t = fs.nextInt();
            time[i] = t;
            possible[i] = fs.nextInt();
            for(int j = 0;j<possible[i];j++){
                node = fs.nextInt();
                adj[node].add(i);
            }
        }
        
        bfs();
        System.out.print(ret);
    }
    
    static void bfs(){
        Queue<Integer> q =new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (possible[i] == 0) {
                dist[i] = time[i];
                q.offer(i);
                ret = Math.max(ret, dist[i]);
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer next : adj[cur]){
                dist[next] = Math.max(dist[next],dist[cur] + time[next]);
                possible[next]--;
                if(possible[next] == 0){
                    q.offer(next);
                    ret = Math.max(ret,dist[next]);
                }
            }
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
