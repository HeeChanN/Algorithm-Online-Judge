// https://www.acmicpc.net/problem/3108

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int [] dir = {1,2,4,8};
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] sx = new int[1004];
    static int [] sy = new int[1004];
    static int [] ex = new int[1004];
    static int [] ey = new int[1004];
    static int [][] board = new int[1004][1004];
    static int [][] visited = new int[1004][1004];
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();

        for(int i = 0; i<n;i++){
            sx[i] = fs.nextInt() + 500;
            sy[i] = fs.nextInt() + 500;
            ex[i] = fs.nextInt() + 500;
            ey[i] = fs.nextInt() + 500;
            fillBoard(i);
        }
        
        if(board[500][500] != 0){
            bfs(500,500);
        }
        for(int i = 0; i<n;i++){
            if(visited[sy[i]][sx[i]] == 0){
                cnt++;
                bfs(sy[i],sx[i]);
            }
        }
        System.out.print(cnt);
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            for(int i = 0; i<4;i++){
                int d = dir[i];
                if((d & board[py][px]) > 0){
                    int ny = py + dy[i];
                    int nx = px + dx[i];
                    if(ny < 0 || nx < 0 || ny > 1000 || nx > 1000  || board[ny][nx] == 0){
                        continue;
                    }
                    if(visited[ny][nx] == 0){
                        q.offer(new int[]{ny,nx});
                        visited[ny][nx] = 1;
                    }
                }
            }
        }
    }
    
    static void fillBoard(int idx){
        int y = sy[idx];
        board[y][sx[idx]] = board[y][sx[idx]] | 6;
        for(int i = sx[idx]+1; i<ex[idx];i++){
            board[y][i] = board[y][i] | 10;
        }
        board[y][ex[idx]] =board[y][ex[idx]] | 12; 
        
        y = ey[idx];
        board[y][sx[idx]] = board[y][sx[idx]] | 3;
        for(int i = sx[idx]+1; i<ex[idx];i++){
            board[y][i] = board[y][i] | 10;
        }
        board[y][ex[idx]] =board[y][ex[idx]] | 9; 
        
        int x = sx[idx];
        board[sy[idx]][x] = board[sy[idx]][x] | 6;
        for(int i = sy[idx]+1; i < ey[idx]; i++){
            board[i][x] = board[i][x] | 5;
        }
        board[ey[idx]][x] = board[ey[idx]][x] | 3;
        
        x = ex[idx];
        board[sy[idx]][x] = board[sy[idx]][x] | 12;
        for(int i = sy[idx]+1; i < ey[idx]; i++){
            board[i][x] = board[i][x] | 5;
        }
        board[ey[idx]][x] = board[ey[idx]][x] | 9;
    }
    
    static void print(){
        for(int i = 500; i<=510; i++){
            for(int j = 500;j<=510;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
