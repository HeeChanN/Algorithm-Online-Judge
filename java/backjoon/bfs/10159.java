// https://www.acmicpc.net/problem/10159

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,m;
    static ArrayList<Integer>[] adj = new ArrayList[104];
    static int [] know = new int[104];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 1; i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
        }
        
        Arrays.fill(know, n-1);
        
        for(int i = 1; i<=n;i++){
            Queue<Integer> q = new ArrayDeque<>();
            boolean [] visited = new boolean[104];
            q.offer(i);
            int cnt = 0;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : adj[cur]){
                    if(visited[next]){
                        continue;
                    }
                    q.offer(next);
                    know[next]--;
                    cnt++;
                    visited[next] = true;
                }
            }
            know[i] -= cnt;
        }
        
        for(int i = 1;i<=n;i++){
            sb.append(know[i]).append("\n");
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
