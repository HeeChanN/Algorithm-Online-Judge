import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int [][] flow = new int[401][401];
    static int [][] capacity = new int[401][401];
    static ArrayList<Integer> adj[] = new ArrayList[401];
    
    static int n,p;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        p = fs.nextInt();
        
        for(int i = 0; i<401;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<p;i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            
            adj[u].add(v);
            adj[v].add(u);
            capacity[u][v] += 1;
        }
        
        System.out.print(maxFlow(1,2));
    }
    
    static int maxFlow(int src, int sink){
        int totalFlow = 0;
        int [] parent = new int[401];
        while(true){
            Queue<Integer> q = new ArrayDeque<>();
            Arrays.fill(parent,-1);
            q.offer(src);
            // r = c - f
            while(!q.isEmpty() && parent[sink] == -1){
                int cur = q.poll();
                for(int next : adj[cur]){
                    if(capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1){
                        q.offer(next);
                        parent[next] = cur;
                    }
                }
            }
            
            if(parent[sink] == -1){
                break;
            }
            
            // for(int i = sink; i!=src; i = parent[i]){
            //     System.out.print(i+ " ");
            // }
            // System.out.println();
            
            
            int amount = Integer.MAX_VALUE;
            for(int i = sink; i != src; i = parent[i]){
                amount = Math.min(amount, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            
            
            for(int i = sink; i!=src; i = parent[i]){
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }
            totalFlow += amount;
        }
        return totalFlow;
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
