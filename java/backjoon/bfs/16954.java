//https://www.acmicpc.net/problem/16954
import java.util.*;
import java.io.*;

class Main {
    
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int [] dx = {0,0,1,1,1,0,-1,-1,-1};
    
    static FastScanner fs = new FastScanner();
    static String[] board = new String[8];
    static int [][] arr = new int[8][8];
    static int [][] visited = new int[8][8];
    
    static int cnt = 0;
    static int ret = 1;
    
    public static void main(String[] args) throws Exception {
        for(int i = 0; i<8;i++){
            board[i] = fs.next();
            for(int j = 0;j<8;j++){
                if(board[i].charAt(j) == '#'){
                    arr[i][j] = 1;
                    cnt++;
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }
        isPossible();
        System.out.print(ret);
    }
    
    static void isPossible(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{7,0});
        int time = 1;
        visited[7][0] = time;
        while(true){
            if(cnt == 0){
                ret = 1;
                return ;
            }
            int s = q.size();
            for(int i = 0; i<s;i++){
                int [] cur = q.poll();
                int py = cur[0];
                int px = cur[1];
                if(arr[py][px] == 1){
                    continue;
                }
                for(int j = 0;j<9;j++){
                    int ny = py + dy[j];
                    int nx = px + dx[j];
                    if(ny < 0 || nx < 0 || ny >=8 || nx >= 8|| arr[ny][nx] == 1){
                        continue;
                    }
                    if(visited[ny][nx] == time + 1){
                        continue;
                    }
                    visited[ny][nx] = time + 1;
                    q.offer(new int[]{ny,nx});
                }
                
            }
            time++;
            if(q.isEmpty()){
                ret = 0;
                return ;
            }
            
            // 블록 움직이기
            moveBlock();
        }
        
    }
    static void moveBlock(){
        for(int i = 7;i>=0;i--){
            for(int j = 0; j<=7;j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 0;
                    if(i + 1 < 8){
                        arr[i+1][j] = 1;
                    }
                    else{
                        cnt--;
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
