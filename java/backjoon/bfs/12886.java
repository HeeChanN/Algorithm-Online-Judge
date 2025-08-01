//https://www.acmicpc.net/problem/12886

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int s;
    static int [] arr = new int[3];
    static int [][] visited = new int[1504][1504];
    static int ret = 0;
    
    public static void main(String[] args) throws Exception {
        arr[0] = fs.nextInt();
        arr[1] = fs.nextInt();
        arr[2] = fs.nextInt();
        s = arr[0] + arr[1] + arr[2];
        if(s%3 != 0){
            System.out.print(ret);
        }
        else{
            Arrays.sort(arr);
            bfs();
            System.out.print(ret);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{arr[0],arr[1]});
        visited[arr[0]][arr[1]] = 1;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int z = s - x - y;
            if (x == y && y == z) { 
                ret = 1;
                return; 
            }
            int[][] pairs = {{x, y}, {x, z}, {y, z}};
             for (int[] p : pairs){
                int small = p[0]; 
                int large = p[1];
                if (small == large) continue;
                if (small > large) { 
                    int tmp = small; 
                    small = large; 
                    large = tmp; 
                }

                int newSmall = small + small;
                int newLarge = large - small;
                int newOther = s - newSmall - newLarge;

                int[] next = {newSmall, newLarge, newOther};
                Arrays.sort(next);
                int a = next[0];
                int b = next[1];

                if (visited[a][b] != 1) {
                    visited[a][b] = 1;
                    q.offer(new int[]{a, b});
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
