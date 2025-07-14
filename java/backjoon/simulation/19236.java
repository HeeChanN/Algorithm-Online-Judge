import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int ret = 0;
    
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    
    
    public static void main(String[] args) throws Exception{
        int [][] board = new int[4][4];
        int [] dir = new int[17];
        int [] shark = new int[4];
        
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                board[i][j] = fs.nextInt();
                dir[board[i][j]] = fs.nextInt()-1;
            }
        }
        
        shark[0] = 0;
        shark[1] = 0;
        shark[2] = board[0][0];
        shark[3] = dir[board[0][0]];
        board[0][0] = 17;
        simulation(shark, board, dir);
        System.out.print(ret);
    }
    
    static void simulation(int[]shark, int [][]board, int []dir){
        int flag = 0;
        int [] dirCopy = dir.clone();
        int [][] boardCopy = new int[4][4];
        for(int i = 0; i<4;i++){
            for(int j = 0;j<4;j++){
                boardCopy[i][j] = board[i][j];
            }
        }
        
        for(int i = 1; i<=16; i++){
            flag = 0;
            for(int y = 0; y < 4; y++){
                for(int x = 0; x<4;x++){
                    if(flag == 0 && i == boardCopy[y][x]){
                       int cur = dirCopy[i];
                       while(true){
                           int ny = y + dy[cur];
                           int nx = x + dx[cur];
                           if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || boardCopy[ny][nx] == 17){
                               cur = (cur + 1) % 8;
                           }
                           else{
                               int tmp = boardCopy[ny][nx];
                               boardCopy[ny][nx] = boardCopy[y][x];
                               boardCopy[y][x] = tmp;
                               dirCopy[i] = cur;
                               break;
                           }
                           if(cur == dirCopy[i]){
                               break;
                           }
                       } 
                       flag = 1;
                    }
                }
            }
        }
    
        //상어 이동
        int ny = shark[0];
        int nx = shark[1];
        while(true){
            ny = ny + dy[shark[3]];
            nx = nx + dx[shark[3]];
            if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4){
                ret = Math.max(ret, shark[2]);
                break;
            }
            if(boardCopy[ny][nx] == 0){
                continue;
            }
            // new shark 생성
            int [] new_shark = {ny,nx,shark[2]+boardCopy[ny][nx],dirCopy[boardCopy[ny][nx]]};
            int tmp = boardCopy[ny][nx];
            boardCopy[shark[0]][shark[1]] = 0;
            boardCopy[ny][nx] = 17;
            simulation(new_shark, boardCopy, dirCopy);
            boardCopy[shark[0]][shark[1]] = 17;
            boardCopy[ny][nx] = tmp;
        }
        return;
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
