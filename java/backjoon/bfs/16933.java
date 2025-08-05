// https://www.acmicpc.net/problem/16933

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m,k;
    
    static String[] str = new String[1004];
    static int[][] board = new int[1004][1004];
    
    // 낮밤, 충돌 가능 횟수, y,x
    static int[][][][] visited = new int[2][11][1004][1004];
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            str[i] = fs.next();
            for(int j = 0; j<m;j++){
                if(str[i].charAt(j) == '1'){
                    board[i][j] = 1;
                }
            }
        }
        for(int [][][] a : visited){
            for(int [][] b : a){
                for(int [] c : b){
                    Arrays.fill(c, 987654321);
                }
            }
        }
        bfs();
        int ret = 987654321;
        for(int i = 0; i<=k;i++){
            ret = Math.min(ret, Math.min(visited[0][i][n-1][m-1], visited[1][i][n-1][m-1]));
        }
        if(ret == 987654321){
            ret = -1;
        }
        System.out.print(ret);
    }
    // 0 : 낮, 1 : 밤
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,k,0,0});
        visited[0][k][0][0] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int flag = cur[0];
            int crash = cur[1];
            int py = cur[2];
            int px = cur[3];
            for(int i = 0;i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                    continue;
                }
                if((flag == 0 && board[ny][nx] == 1 && crash > 0)){
                    if(visited[(flag + 1) % 2][crash-1][ny][nx] > visited[flag][crash][py][px] + 1){
                        visited[(flag + 1) % 2][crash-1][ny][nx] = visited[flag][crash][py][px] + 1;
                        q.offer(new int[]{(flag+1) % 2, crash-1, ny, nx});
                    }
                }
                else if (board[ny][nx] == 0){
                    if(visited[(flag + 1) % 2][crash][ny][nx] > visited[flag][crash][py][px] + 1){
                        visited[(flag + 1) % 2][crash][ny][nx] = visited[flag][crash][py][px] + 1;
                        q.offer(new int[]{(flag+1) % 2, crash, ny, nx});
                    }
                }
            }
            if (visited[1 - flag][crash][py][px] > visited[flag][crash][py][px] + 1) {
            visited[1 - flag][crash][py][px] = visited[flag][crash][py][px] + 1;
            q.offer(new int[]{1 - flag, crash, py, px});
        }
        }
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
