//https://www.acmicpc.net/problem/18430

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int [][] dir = {
        {-1,0,0,-1},
        {-1,0,0,1},
        {1,0,0,1},
        {1,0,0,-1}
    };
    
    static int n,m;
    static int [][] arr = new int[5][5];
    static int [][] visited = new int[5][5];
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                arr[i][j] = fs.nextInt();
            }
        }
        go(0);
        System.out.print(ret);
    }
    
    static void go(int idx){
        if(idx >= n * m){
            calc();
            return;
        }
        go(idx + 1);
        int y = idx / m;
        int x = idx % m;
        if(visited[y][x] != 0){
            return;
        }
        for(int i = 0; i<4;i++){
            int [] d = dir[i];
            int y1 = y + d[0];
            int x1 = x + d[1];
            int y2 = y + d[2];
            int x2 = x + d[3];
            if(y1 < 0 || x1 < 0 || y2 < 0 || x2 < 0 || y1 >= n || x1 >= m || y2 >= n || x2 >= m){
                continue;
            }
            if(visited[y1][x1] != 0 || visited[y2][x2] != 0){
                continue;
            }
            visited[y1][x1] = 1;
            visited[y2][x2] = 1;
            visited[y][x] = 2;
            go(idx+1);
            visited[y1][x1] = 0;
            visited[y2][x2] = 0;
            visited[y][x] = 0;
        }
    }
    
    static void calc(){
        int s = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                s += visited[i][j] * arr[i][j];
            }
        }
        ret = Math.max(ret, s);
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
