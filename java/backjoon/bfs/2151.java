//https://www.acmicpc.net/problem/2151

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int[][] board = new int[54][54];
    static int[][][] dist = new int[54][54][4];
    
    static int n;
    static int ret = 987654321;
    
    static ArrayList<int[]> door = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            String tmp = fs.next();
            for(int j = 0; j<n;j++){
                if(tmp.charAt(j) =='*'){
                    board[i][j] = 1;
                }
                else if(tmp.charAt(j) == '!'){
                    board[i][j] = 2;
                }
                else if (tmp.charAt(j) == '#'){
                    door.add(new int[]{i,j});
                }
            }
        }
        for(int [][] arr : dist){
            for(int [] row : arr){
                Arrays.fill(row, 987654321);
            }
        }
        bfs();
        for(int i = 0; i<4;i++){
            ret = Math.min(ret, dist[door.get(1)[0]][door.get(1)[1]][i]);
        }
        System.out.print(ret);
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            dist[door.get(0)[0]][door.get(0)[1]][d] = 0;
            q.offer(new int[]{door.get(0)[0],door.get(0)[1],d});
        }
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            int dir = cur[2];
            
            int ny = py + dy[dir];
            int nx = px + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1){
                continue;
            }
            if(dist[ny][nx][dir] > dist[py][px][dir]){
                dist[ny][nx][dir] = dist[py][px][dir];
                q.offer(new int[]{ny,nx,dir});
            }
            if(board[ny][nx] == 2){
                int left = (dir + 3) % 4;
                int right = (dir + 1) % 4;
                
                if(dist[ny][nx][left] > dist[py][px][dir] + 1){
                    dist[ny][nx][left] = dist[py][px][dir] + 1;
                    q.offer(new int[]{ny,nx,left});
                }
                if (dist[ny][nx][right] > dist[py][px][dir] + 1) {
                    dist[ny][nx][right] = dist[py][px][dir] + 1;
                    q.offer(new int[]{ny, nx, right});
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
