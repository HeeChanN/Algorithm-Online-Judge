import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static int n,m,k;
    static int y,x;
    static int ret = 0;
    static int [][] board = new int[104][104];
    static int [][] visited = new int[104][104];
    static Queue<int[]> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<k;i++){
            y = fs.nextInt();
            x = fs.nextInt();
            q.offer(new int[]{y,x});
            board[y][x] = 1;
        }
        while(!q.isEmpty()){
            int [] next = q.poll();
            y = next[0];
            x = next[1];
            if(visited[y][x] == 1){
                continue;
            }
            bfs();
        }
        System.out.print(ret);
    }
    
    static void bfs(){
        Queue<int[]> bq = new ArrayDeque<>();
        bq.offer(new int[] {y,x});
        visited[y][x] = 1;
        int cnt = 1;
        while(!bq.isEmpty()){
            int [] pos = bq.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny <= 0 || nx <= 0 || ny > n || nx > m || board[ny][nx] == 0){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    bq.offer(new int[]{ny,nx});
                    visited[ny][nx] = 1;
                    cnt++;
                }
            }
        }
        ret = Math.max(ret,cnt);
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()
            ){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
