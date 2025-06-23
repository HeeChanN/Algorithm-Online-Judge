import java.util.*;
import java.io.*;

class Main {
    
    static class Pair{
        int w;
        int node;
        
        public Pair(int w, int node){
            this.w = w;
            this.node = node;
        }
    }
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static int a,b,c;
    
    static ArrayList<Pair>[] adj = new ArrayList[100004];
    static PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p)-> p.w).reversed());
    static int [] limit = new int[100004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            c = fs.nextInt();
            adj[a].add(new Pair(c,b));
            adj[b].add(new Pair(c,a));
        }
        
        a = fs.nextInt();
        b = fs.nextInt();
        pq.offer(new Pair(1000000001,a));
        limit[a] = 1000000001;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(limit[p.node] != p.w){
                continue;
            }
            for(Pair next : adj[p.node]){
                int w = Math.min(next.w, p.w);
                if(limit[next.node] < w){
                    limit[next.node] = w;
                    if(next.node == b){
                        continue;
                    }
                    pq.offer(new Pair(w,next.node));
                }
            }
        }
        System.out.print(limit[b]);
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
