import java.util.*;
import java.io.*;


class Main {
    
    static FastScanner fs = new FastScanner();
    static int[][] tobni = new int [5][8];
    static int[] visited = new int[5];
    static int k;
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        for(int i = 1;i<=4;i++){
            String s = fs.next();
            for(int j=0;j<s.length();j++){
                tobni[i][j] = s.charAt(j)-'0';
            }
        }
        k = fs.nextInt();
        for(int i = 0; i<k;i++){
            int idx = fs.nextInt();
            int dir = fs.nextInt();
            Arrays.fill(visited, 0);
            rotate(idx, dir);
        }
        int a = 1;
        for(int i = 1; i<=4;i++){
            ret += tobni[i][0] * a;
            a = a * 2;
        }
        System.out.print(ret);
    }
    
    static void rotate(int idx, int dir){
        visited[idx] = 1;
        if((idx -1 != 0) && (visited[idx -1] == 0) && (tobni[idx][6] != tobni[idx-1][2])){
            rotate(idx-1,dir * -1);
        }
        if((idx + 1 != 5) && (visited[idx + 1] == 0) && (tobni[idx][2] != tobni[idx+1][6])){
            rotate(idx+1, dir*-1);
        }
        if(dir == 1){
            rotate_right(idx);
        }
        else{
            rotate_left(idx);
        }
    }
    
    static void rotate_right(int idx){
        int tmp = tobni[idx][7];
        for(int i = 7; i>0;i--){
            tobni[idx][i] = tobni[idx][i-1];
        }
        tobni[idx][0] = tmp;
    }
    
    static void rotate_left(int idx){
        int tmp = tobni[idx][0];
        for(int i = 0; i<7;i++){
            tobni[idx][i] = tobni[idx][i+1];
        }
        tobni[idx][7] = tmp;
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
