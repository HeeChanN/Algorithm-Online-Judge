import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static long [] h = new long [54];
    static int [] visited = new int[54];
    static int ret = 0;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            h[i] = fs.nextLong();
        }
        
        for(int i = 0; i<n;i++){
            for(int j = i+1;j<n;j++){
                canSee(i,j);
            }
        }
        for(int i = 0;i<n;i++){
            ret = Math.max(ret, visited[i]);
        }
        
        System.out.print(ret);
    }
    
    static void canSee(int s, int e){
        long py = h[s];
        long px = (long)s;
        long ty = h[e];
        long tx = (long)e;
        
        for(int i = s+1; i<e;i++){
            long my = h[i];
            long mx = (long)i;
            if((my - py) *(tx-px) >= (ty - py) *(mx - px)){
                return;
            }
        }
        visited[s]++;
        visited[e]++;
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception {
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
        
        long nextLong() throws Exception{
            return Long.parseLong((next()));
        }
    }
}
