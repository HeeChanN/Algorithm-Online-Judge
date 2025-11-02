import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static long [] dist = new long[100004];
    static long [] price = new long[100004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<n-1;i++){
            dist[i] = fs.nextLong();
        }
        
        for(int i = 0; i<n;i++){
            price[i] = fs.nextLong();
        }
        
        long cur = price[0];
        long d = dist[0];
        int idx = 1;
        long ret = 0;
        while(true){
            // if(idx == n-1){
                
            // }
            while(cur < price[idx]){
                if(idx == n-1){
                    break;
                }
                d += dist[idx];
                idx++;
            }
            if(idx == n-1){
                ret += cur * d;
                break;
            }
            ret += cur * d;
            cur = price[idx];
            d = dist[idx];
            idx++;
        }
        System.out.print(ret);
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
