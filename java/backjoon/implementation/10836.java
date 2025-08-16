// https://www.acmicpc.net/problem/10836

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int[] arr = new int[704];
    static int[][] board = new int[704][704];
    static int n,m;
    
    public static void main(String[] args) throws Exception{
        m = fs.nextInt();
        n = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            
            int [] tmp = new int[3];
            for(int j = 0; j<3;j++){
                tmp[j] = fs.nextInt();
            }
            int py = 0;
            int px = m-1;
            for(int j = 2;j>=0;j--){
                for(int k = 0; k<tmp[j];k++){
                    board[py][px] += j;
                    if(px != 0){
                        arr[px] +=j;
                    }
                    px--;
                    if(px < 0){
                        px = 0;
                        py = py + 1;
                    }
                }
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1; j<m;j++){
                board[i][j] += arr[j];
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0; j<m;j++){
                sb.append(board[i][j]+1).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
