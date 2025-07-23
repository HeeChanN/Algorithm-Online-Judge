// https://www.acmicpc.net/problem/14267

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int num;
    
    static ArrayList<Integer>[] graph = new ArrayList[100004];
    static int[] score = new int[100004];
    static int[] ret = new int[100004];
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 1; i<100001;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 1; i<=n;i++){
            num = fs.nextInt();
            if(i > 1){
                graph[num].add(i);
            }
        }
        for(int i = 0;i<m;i++){
            num = fs.nextInt();
            score[num] += fs.nextInt();
        }
        bfs();
        for(int i = 1;i<=n;i++){
            sb.append(ret[i]+" ");
        }
        System.out.print(sb);
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        while(!q.isEmpty()){
            int []p = q.poll();
            for(int next : graph[p[0]]){
                ret[next] = score[next] + p[1];
                q.offer(new int[]{next,ret[next]});
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
