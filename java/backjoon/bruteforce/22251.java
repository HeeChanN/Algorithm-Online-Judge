import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int[][] led = {
        {1,1,1,0,1,1,1},
        {0,0,1,0,0,1,0},
        {1,0,1,1,1,0,1},
        {1,0,1,1,0,1,1},
        {0,1,1,1,0,1,0},
        {1,1,0,1,0,1,1},
        {1,1,0,1,1,1,1},
        {1,0,1,0,0,1,0},
        {1,1,1,1,1,1,1},
        {1,1,1,1,0,1,1}
    };
    
    static int[][] need = new int[10][10];
    
    static int n,k,p;
    static String x;
    static int ret=0;
    
    
    public static void main(String[] args) throws Exception{
        init();
        StringBuilder sb = new StringBuilder();
        go(0,p,sb);
        System.out.print(ret-1);
    }
    
    static void go(int idx, int lim, StringBuilder sb){
        if(idx == k){
            int a = Integer.parseInt(sb.toString());
            if(n>= a && a >= 1){
                ret++;
            }
            return;
        }
        char ch = x.charAt(idx);
        int num = ch-'0';
        
        for(int i = 0; i<10;i++){
            if(lim - need[num][i] >=0){
                sb.append(i);
                go(idx+1, lim - need[num][i],sb);
                sb.deleteCharAt(sb.length() -1);
            }
        }
    }
    
    static void init()throws Exception{
        StringBuilder sb = new StringBuilder();
        n = fs.nextInt();
        k = fs.nextInt();
        p = fs.nextInt();
        x = fs.next();
        if(k>x.length()){
            for(int i = 0 ;i<k-x.length();i++){
                sb.append('0');
            }
            sb.append(x);
            x = sb.toString();
        }
        for(int i = 0; i<10;i++){
            for(int j = i+1;j<10;j++){
                need[i][j] = calcLed(i,j);
                need[j][i] = need[i][j];
            }
        }
    }
    
    static int calcLed(int number, int nextNumber){
        int cnt = 0;
        for(int i = 0; i<7;i++){
            if(led[number][i] != led[nextNumber][i]){
                cnt++;
            }
        }
        return cnt;
    }
    
    static class FastScanner {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
