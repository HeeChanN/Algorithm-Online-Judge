//https://www.acmicpc.net/problem/6087

import java.util.*;
import java.io.*;

class Main {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static String[] board = new String[104];
    static ArrayList<int[]> c = new ArrayList<>();
    static int[][][] visited = new int[4][104][104];
    
    public static void main(String[] args) throws Exception {
        m = fs.nextInt();
        n = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            board[i] = fs.next();
            for(int j = 0;j<m;j++){
                if(board[i].charAt(j) == 'C'){
                    c.add(new int[]{i,j});
                }
            }
        }
        for(int [][] arr : visited){
            for(int [] row : arr){
                Arrays.fill(row, 987654321);
            }
        }
        bfs(c.get(0)[0], c.get(0)[1]);
        int ret = 987654321;
        for(int i = 0; i<4;i++){
            ret = Math.min(ret, visited[i][c.get(1)[0]][c.get(1)[1]]);
        }
        System.out.print(ret);
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i<4;i++){
            int nny = y + dy[i];
            int nnx = x + dx[i];
            if(nny < 0 || nnx < 0 || nny >= n || nnx >= m || board[nny].charAt(nnx) == '*'){
                    continue;
            }
            q.offer(new int[]{nny,nnx,i});
            visited[i][nny][nnx] = 0;
            visited[i][y][x] = 0;
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            if(py == c.get(1)[0] && px == c.get(1)[1]){
                continue;
            }
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny].charAt(nx) == '*'){
                    continue;
                }
                if(cur[2] == i && visited[i][ny][nx] > visited[i][py][px]){
                    visited[i][ny][nx] = visited[i][py][px];
                    q.offer(new int[]{ny,nx,i});
                }
                else if (cur[2] != i && visited[i][ny][nx] > visited[cur[2]][py][px] + 1){
                    visited[i][ny][nx] = visited[cur[2]][py][px] + 1;
                    q.offer(new int[]{ny,nx,i});
                }
            }
        }
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                System.out.print(visited[2][i][j] + " ");
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
