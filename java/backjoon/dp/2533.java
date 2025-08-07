// https://www.acmicpc.net/problem/2533

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,a,b;
    static ArrayList<Integer>[] adj = new ArrayList[1000004];
    static int [] visited = new int[1000004];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> -a[1]));
    
    static int [][] dp = new int[1000004][2];
    
    public static void main(String[] args) throws Exception{
        for(int i = 0; i<1000004;i++){
            adj[i] = new ArrayList<>();
        }
        n = fs.nextInt();
        for(int i = 0; i<n-1;i++){
            a= fs.nextInt();
            b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        
        set_depth();
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            dp[cur[0]][1] = 1;
            for(int child : adj[cur[0]]){
                if(visited[cur[0]] < visited[child]){
                    dp[cur[0]][0] += dp[child][1];
                    dp[cur[0]][1] += Math.min(dp[child][0], dp[child][1]);
                }
            }
        }
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
    
    static void set_depth(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,1});
        pq.offer(new int[]{1,1});
        visited[1] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int next : adj[cur[0]]){
                if(visited[next] == 0){
                    q.offer(new int[]{next,cur[1]+1});
                    pq.offer(new int[]{next,cur[1]+1});
                    visited[next] = cur[1] + 1;
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
