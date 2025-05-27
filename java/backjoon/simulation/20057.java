import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int sy, sx;
    static int ret = 0;
    static int [][] board = new int[504][504];
    
    static int []dy = {0,1,0,-1};
    static int []dx = {-1,0,1,0};
    static int [][] base = {
        {-2,  0,  2},{ 2,  0,  2},{ 0, -2,  5},
        {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1},
        { 1, -1, 10}, { 1, 0, 7}, { 1, 1, 1},{ 0, -1, 55}
    };
    static ArrayList<int[]> []  wind = new ArrayList[4];
    
    public static void main(String[] args) throws Exception {
        init();
        move();
        System.out.print(ret);
    }
    
    static void move(){
        int t = 0;
        sy = n / 2;
        sx = n / 2;
        int move = 1;
        int dir = 0;
        while(true){
            for(int i =0 ; i<2;i++){
                for(int j = 0;j<move;j++){
                    sy = sy + dy[dir];
                    sx = sx + dx[dir];
                    calcSand(dir);
                    board[sy][sx] = 0;
                }
                dir = (dir+1) % 4;
            }
            move = move + 1;
            if(sy == 0 && sx == n-1){
                for(int i =0;i<move-1;i++){
                    sy = sy + dy[dir];
                    sx = sx + dx[dir];
                    calcSand(dir);
                    board[sy][sx] = 0;
                }
                break;
            }
            // for(int i = 0; i<n;i++){
            //     for(int j = 0; j<n;j++){
            //         System.out.print(board[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
    }
    
    static void calcSand(int dir){
        int s = 0;
        int v;
        for(int [] p : wind[dir]){
            int ny = sy + p[0];
            int nx = sx + p[1];
            if(p[2] == 55){
                v = board[sy][sx] - s;
            }
            else{
                v = (board[sy][sx] * p[2]) / 100;
                s += v;
            }
            if(ny < 0 || nx < 0 || ny >= n || nx >=n){
                ret += v;
                continue;
            }
            board[ny][nx] += v;
        }
    }
    
    
    static void init() throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
            }
        }
        wind[0] = new ArrayList<>();
        for(int i = 0;i<10;i++){
            wind[0].add(base[i]);
        }
        for(int i = 1; i<4;i++){
            wind[i] = new ArrayList<>();
            for(int [] p : wind[i-1]){
                int nx = p[0];
                int ny = -p[1];
                wind[i].add(new int[]{ny,nx,p[2]});
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
