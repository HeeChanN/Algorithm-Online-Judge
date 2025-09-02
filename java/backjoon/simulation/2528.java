// https://www.acmicpc.net/problem/2528
import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static int [][] board = new int[3004][3];
    static int floor = 1;
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        // 디버깅 포인트 1 (각층의 left, right 확인)
        for(int i = 1; i<=n;i++){
            int l = fs.nextInt();
            int d = fs.nextInt();
            if(d == 0){
                board[i][0] = 1;
                board[i][1] = l;
                board[i][2] = d;
            }
            else{
                board[i][0] = m-l+1;
                board[i][1] = m;
                board[i][2] = d;
            }
        }
        int ret = 0;
        while(true){
            canClimb();
            move();
            if(floor == n){
                break;
            }
            ret++;
        }
        System.out.print(ret);
    }
    
    static void canClimb(){
        int flag = 0;
        while(true){
            flag = 0;
            int l = board[floor][0];
            int r = board[floor][1];
            for(int i = l-1; i<=r+1;i++){
                if(i < 1 || i > m){
                    continue;
                }
                if(board[floor+1][0] <= i && i <= board[floor+1][1]){
                    floor++;
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                break;
            }
            if(floor == n){
                break;
            }
        }
    }
    
    static void move(){
        for(int i = 1; i<=n;i++){
            if(board[i][2] == 0){
                board[i][0]++;
                board[i][1]++;
                if(board[i][1] == m){
                    board[i][2] = 1;
                }
            }
            else{
                board[i][0]--;
                board[i][1]--;
                if(board[i][0] == 1){
                    board[i][2] = 0;
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
