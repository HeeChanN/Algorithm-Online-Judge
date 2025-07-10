import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,ret;
    static int[][] board = new int[503][503];
    static int[][] visited = new int[503][503];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                board[i][j] = fs.nextInt();
                pq.offer(new int[]{board[i][j],i,j});
            }
        }
        
        while(!pq.isEmpty()){
            int [] pos = pq.poll();
            int num = pos[0];
            int y = pos[1];
            int x = pos[2];
            for(int i = 0; i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] <= num){
                    continue;
                }
                visited[ny][nx] = Math.max(visited[ny][nx], visited[y][x] + 1);
            }
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                ret = Math.max(ret , visited[i][j]);
            }
         }
         System.out.print(ret+1);
    }
    
    static void go(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = 1;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] < board[py][px]){
                    continue;
                }
                if(visited[ny][nx] <visited[py][px] + 1){
                    visited[ny][nx] = visited[py][px] + 1;
                    q.offer(new int[]{ny,nx});
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
