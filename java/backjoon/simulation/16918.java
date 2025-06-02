import java.util.*;
import java.io.*;

// R x C인 격자판 각 칸은 비어있거나 폭탄이 있음

// 폭탄은 3초가 지난 후 폭발
// 폭탄이 있던 칸은 파괴되어 빈칸이 된다.
// 인접한 칸 4칸도 빈칸이 됨

// 1. 일부 칸에 폭탄 설치
// 2. 1초동안 아무것도 하지 않는다.
// 3. 폭탄이 설치되어있지 않은 모든칸에 폭탄 설치
// 4. 1초 후 3초전에 설치된 폭탄이 모두 폭발
// 3과 4를 반복


// N초가 흐른 후의 격자판 상태를 구하기


class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int r,c,n; // r: row, c : col
    static char[][] board = new char[204][204];
    static  String tmp;
    static int t = 1;
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        r = fs.nextInt();
        c = fs.nextInt();
        n = fs.nextInt();
        
        for(int i = 0;i<r;i++){
            tmp = fs.next();
            for(int j=0;j<c;j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        
        while(t<n){
            t++;
            if(t%2==0){
                fillBoard();
            }
            else{
                bomb();
            }
        }
        for(int i = 0; i<r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j] == 'X' || board[i][j] == 'O'){
                    sb.append("O");
                }
                else{
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static void fillBoard(){
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '.'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    static void bomb(){
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j] == 'X'){
                    changeBoard(i,j);
                }
            }
        }
    }
    
    static void changeBoard(int y,int x){
        board[y][x] = '.';
        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny <0 || nx < 0 || ny >=r || nx >=c || board[ny][nx] == 'X'){
                continue;
            }
            board[ny][nx] = '.';
        }
    }

    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st ==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
