//https://www.acmicpc.net/problem/1766

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,m,a,b;
    static int[] arr = new int[32004];
    static ArrayList<Integer>[] adj = new ArrayList[32004];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<32004;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            if(a != b){
                arr[b]++;
                adj[a].add(b);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for (int next : adj[cur]) {
                arr[next]--;
                if (arr[next] == 0) {
                    pq.offer(next);
                }
            }
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
        
        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
