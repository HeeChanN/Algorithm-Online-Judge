import java.util.*;
import java.io.*;

class Main {
    
    static final int[][] CASE = {
        {1,0,0},{0,1,0},{0,0,1},
        {1,1,0},{1,0,1},{0,1,1},
        {1,1,1}
    };
    
    static FastScanner fs = new FastScanner();
    static int s,p1,p2,p3;
    static int [][][][] dp = new int[52][52][52][52];
    
    public static void main(String[] args) throws Exception{
        s = fs.nextInt();
        p1 = fs.nextInt();
        p2 = fs.nextInt();
        p3 = fs.nextInt();
        
        for (int[][][] arr3 : dp)
            for (int[][] arr2 : arr3)
                for (int[] arr1 : arr2)
                    Arrays.fill(arr1, -1);

        System.out.println(solve(s,p1,p2,p3));
    }
    
    static int solve(int s,int a,int b,int c){
        if(s<0||a<0||b<0||c<0){ 
            return 0;
        }
        if(s==0){ 
            return (a==0&&b==0&&c==0)?1:0;
        }
        if(dp[s][a][b][c]!=-1) {
            return dp[s][a][b][c];
        }
        long sum = 0;
        for(int[] t:CASE)
            sum += solve(s-1,a-t[0],b-t[1],c-t[2]);
        return dp[s][a][b][c] = (int)(sum%1000000007);
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
