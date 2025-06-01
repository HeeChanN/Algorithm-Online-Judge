import java.util.*;
import java.io.*;

// 최소한의 소를 만나고 싶다
// N개의 헛간 (1개 이상, 5만 이하)
// M마리의 길 (1개 이상, 5만 이하)
// c -> 길의 가중치

// 1에서 n까지 가는 최저 비용의 길 선택

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int a,b,w;
    static ArrayList<int []>[] adj = new ArrayList[50004];
    
    static int[] dist = new int[50004];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[]a) -> a[0]));
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 1; i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i  =0; i<m;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            w = fs.nextInt();
            adj[a].add(new int[]{w,b});
            adj[b].add(new int[]{w,a});
        }
        
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        pq.offer(new int[]{0,1});
        while(!pq.isEmpty()){
            int [] pos = pq.poll();
            int p = pos[1];
            int d = pos[0];
            if(dist[p] != d){
                continue;
            }
            for(int[] next : adj[p]){
                int np = next[1];
                int nd = next[0];
                
                if(dist[np] > nd + d ){
                    dist[np] = nd+d;
                    pq.offer(new int[]{dist[np],np});
                }
            }
        }
        System.out.print(dist[n]);
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
