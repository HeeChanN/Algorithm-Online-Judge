import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int dy [] = {-1,0,1,0};
    static int dx [] = {0,1,0,-1};
    
    
    static int [][] board = new int[504][504];
    static int [][] life = new int[504][504];
    static int n,m;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        fillBoard(n,1);
        m = fs.nextInt();
        fillBoard(m,2);
        
        for(int [] row : life){
            Arrays.fill(row, 987654321);
        }
        bfs();
        if(life[500][500] == 987654321){
            System.out.print("-1");
        }
        else{
            System.out.print(life[500][500]);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        life[0][0] = 0;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >500 || nx >500 || board[ny][nx] == 2){
                    continue;
                }
                if(board[ny][nx] == 0){
                    if(life[py][px] < life[ny][nx]){
                        life[ny][nx] = life[py][px];
                        q.offer(new int[]{ny,nx});
                    }
                }
                else if(board[ny][nx] == 1 && (life[py][px] + 1 < life[ny][nx])){
                    life[ny][nx] = life[py][px] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    static void fillBoard(int t, int area) throws Exception{
        for(int i = 0; i<t;i++){
            int x1 = fs.nextInt();
            int y1 = fs.nextInt();
            int x2 = fs.nextInt();
            int y2 = fs.nextInt();
            int minx = Math.min(x1,x2);
            int maxx = Math.max(x1,x2);
            int miny = Math.min(y1,y2);
            int maxy = Math.max(y1,y2);
            for(int j = minx;j<=maxx;j++){
                for(int k = miny; k<=maxy;k++){
                    board[j][k] = area;
                }
            }
        }
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
