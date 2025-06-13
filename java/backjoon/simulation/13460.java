import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static String str;
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static char [][] board = new char[11][11];
    static int [][][][][] dp = new int[11][11][11][11][11];
    static int blueY,blueX,redY,redX, ey, ex;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            str = fs.next();
            for(int j = 0;j<m;j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'B'){
                    blueY = i;
                    blueX = j;
                    board[i][j] = '.';
                }
                else if (board[i][j] == 'R'){
                    redY = i;
                    redX = j;
                    board[i][j] = '.';
                }
                else if (board[i][j] == 'O'){
                    ey = i;
                    ex = j;
                }
            }
        }
        init();
        int ret = go(0,blueY, blueX, redY, redX);
        if(ret >= 987654321){
            System.out.print("-1");
        }
        else{
            System.out.print(ret);
        }
    }
    
    static int go(int cnt, int by, int bx, int ry, int rx){
        if(cnt>10){
            return 987654321;
        }
        if(by == ey && bx == ex){
            return 987654321;
        }
        else if (ry == ey && rx == ex){
            return 0;
        }
        if(dp[cnt][by][bx][ry][rx] != 987654321){
            return dp[cnt][by][bx][ry][rx];
        }
        int v = 987654321;
        for(int i = 0; i<4;i++){
            int [] nl = calcNext(by,bx,ry,rx,i);
            v = Math.min(v, go(cnt+1, nl[0],nl[1],nl[2],nl[3]));
        }

        dp[cnt][by][bx][ry][rx] = v + 1;
        return dp[cnt][by][bx][ry][rx];
    }
    
    static int[] calcNext(int by, int bx,int ry, int rx, int dir){
        int [] nb;
        int [] nr;
        if(dir == 0){
            if(by <= ry){
                nb = move(by, bx,ry,rx,dir);
                nr = move(ry, rx,nb[0],nb[1],dir);
            }
            else{
                nr = move(ry, rx,by,bx,dir);
                nb = move(by, bx,nr[0],nr[1],dir);
            }
        }
        else if (dir == 1){
            if(bx >= rx){
                nb = move(by, bx,ry,rx,dir);
                nr = move(ry, rx,nb[0],nb[1],dir);
            }
            else{
                nr = move(ry, rx,by,bx,dir);
                nb = move(by, bx,nr[0],nr[1],dir);
            }
        }
        else if (dir == 2){
             if(by >= ry){
                nb = move(by, bx,ry,rx,dir);
                nr = move(ry, rx,nb[0],nb[1],dir);
            }
            else{
                nr = move(ry, rx,by,bx,dir);
                nb = move(by, bx,nr[0],nr[1],dir);
            }
        }
        else{
             if(bx <= rx){
                nb = move(by, bx,ry,rx,dir);
                nr = move(ry, rx,nb[0],nb[1],dir);
            }
            else{
                nr = move(ry, rx,by,bx,dir);
                nb = move(by, bx,nr[0],nr[1],dir);
            }
        }
        return new int[]{nb[0],nb[1],nr[0],nr[1]};
    }
    
    static int[] move(int y, int x,int cy, int cx, int dir){
        int ny = y;
        int nx = x;

        while(true){
            ny += dy[dir];
            nx += dx[dir];
            if(board[ny][nx] == 'O'){
                return new int[]{ny,nx};
            }
            if(board[ny][nx] == '#' || (cy == ny && cx == nx)) {
                return new int[]{ny-dy[dir],nx-dx[dir]};
            }
        }
    }
    
    static void init(){
          for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int l = 0; l < 11; l++) {
                        Arrays.fill(dp[i][j][k][l], 987654321);
                    }
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
