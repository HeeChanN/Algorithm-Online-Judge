import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static ArrayList<Integer>[] board = new ArrayList[51];
    static int r1,c1,r2,c2;
    static int idx = 0;
    static int[] dy = {1,-1,-1,1};
    static int[] dx = {1,1,-1,-1};
    static int[] h = new int[51];
    
    public static void main(String[] args) throws Exception{
        for(int i = 0; i<51;i++){
            board[i] = new ArrayList<>();
        }
        
        r1 = fs.nextInt();
        c1 = fs.nextInt();
        r2 = fs.nextInt();
        c2 = fs.nextInt();
        if(r1 == 0 && c1 == 0 && r2 == 0 && c2 == 0){
            System.out.print("1");
        }
        else{
            for(int i = r1;i<=r2;i++){
                for(int j = c1;j<=c2;j++){
                    board[idx].add(calcNum(i,j));
                }
                idx++;
            }
        }
        int max = 0;
        for (int i = 0; i < idx; i++) {
            for (int v : board[i]) max = Math.max(max, v);
        }
        int width = calcLength(max); 
        
        for(int i = 0; i<idx;i++){
            for(int j = 0; j<=c2-c1;j++){
                sb.append(String.format("%" + width + "d", board[i].get(j)));
                if(j != c2-c1){
                    sb.append(" ");
                }
            }
            if(i != idx-1){
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    
    static int calcLength(int num){
        int cnt = 0;
        while(num != 0){
            num = num / 10;
            cnt++;
        }
        return cnt;
    }
    
    static int calcNum(int y, int x){
        int k =Math.max(Math.abs(y), Math.abs(x));
        int num = (2*k - 1) * (2*k-1);
        int dir = findDir(y,x,k);
        int dist = Math.abs((dy[dir] * k) - y + (dx[dir] * k) - x);
        return num + (2 * k * dir) + dist; 
    }
    
    static int findDir(int y, int x, int k){
        int minus_k = k * -1;
        
        if(minus_k <= y && y<k && x == k){
            return 0;
        }
        else if(minus_k <= x && x <k && y == minus_k){
            return 1;
        }
        else if(minus_k < y && y<=k && x == minus_k){
            return 2;
        }
        else{
            return 3;
        }
    }
    
    static class FastScanner{
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
