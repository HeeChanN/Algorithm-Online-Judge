import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int [] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static int [][] board = new int[24][24];
    static int [][] visited = new int[24][24];
    static int n;
    static int Y,X;
    static int ty,tx,dist;
    static int sharkSize = 2;
    
    public static void main(String[] args)throws Exception {
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
                if(board[i][j] == 9){
                    Y = i;
                    X = j;
                    board[i][j] = 0;
                }
            }
        }
        int t = 0;
        int cnt = 0;
        while(true){
            init();
            bfs();
            if(dist == 987654321){
                break;
            }
            t += dist-1;
            Y = ty;
            X = tx;
            board[Y][X] = 0;
            cnt++;
            if(cnt == sharkSize){
                sharkSize++;
                cnt = 0;
            }
        }
        System.out.println(t);
    }
    
    static void init(){
        ty = -1;
        tx = -1;
        dist = 987654321;
        for(int [] a : visited){
            Arrays.fill(a,0);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[Y][X] = 1;
        q.offer(new int[]{Y,X});
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0;i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny <0 || nx <0 || ny >= n || nx >= n || board[ny][nx] > sharkSize){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = visited[py][px] + 1;
                    q.offer(new int[]{ny,nx});
                    if(board[ny][nx] != 0 && board[ny][nx] < sharkSize){
                        if(dist > visited[ny][nx]){
                            dist = visited[ny][nx];
                            ty = ny;
                            tx = nx;
                        }
                        else if (dist == visited[ny][nx]){
                            if(ny < ty || (ny == ty && nx < tx)){
                                ty = ny;
                                tx = nx;
                            }
                        }
                    }
                }
            }
        }
    }
    
    static class FastScanner{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
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
