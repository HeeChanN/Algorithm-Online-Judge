// https://www.acmicpc.net/problem/2159

import java.util.*;
import java.io.*;

class Main {
    
    static int[] dy = {0,-1,0,1,0};
    static int[] dx = {0,0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int[][] arr = new int[100004][2];
    static long [][] dp = new long[100004][5];
    static int [] bakery = new int[2];
    static final long INF = Long.MAX_VALUE / 4;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        bakery[1] = fs.nextInt();
        bakery[0] = fs.nextInt();
        
        for(int i = 1; i<=n;i++){
            arr[i][1] = fs.nextInt();
            arr[i][0] = fs.nextInt();
        }
        
        for(int i = n-1; i>=1; i--){
            for(int j = 0; j<5;j++){
                //System.out.println("Start: "+i + " " + j);
                dp[i][j] = minValue(i,j);
            }
        }
        
        int py = bakery[0];
        int px = bakery[1];
        long ret = INF;
        for(int i = 0; i<5;i++){
            int ny = arr[1][0] + dy[i];
            int nx = arr[1][1] + dx[i];
            if(ny < 1 || nx < 1 || ny > 100000 || nx > 100000){
                continue;
            }
            int diff = Math.abs(py - ny) + Math.abs(px - nx);
            ret = Math.min(ret, diff + dp[1][i]);
        }
        System.out.print(ret);
    }
    
    static long minValue(int idx, int pos){
        long best = INF;
        int py = arr[idx][0] + dy[pos];
        int px = arr[idx][1] + dx[pos];
        if(py < 1 || px < 1 || py > 100000 || px > 100000){
            return best;
        }
        
        for(int i = 0; i<5;i++){
            int ny = arr[idx+1][0] + dy[i];
            int nx = arr[idx+1][1] + dx[i];
            if(ny < 1 || nx < 1 || ny > 100000 || nx > 100000){
                continue;
            }
            long diff = Math.abs(py - ny) + Math.abs(px - nx) +dp[idx+1][i];
            if(best > diff){
                best = diff;
            }
        }
        return best;
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
