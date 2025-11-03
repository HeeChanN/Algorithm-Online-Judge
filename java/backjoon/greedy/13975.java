import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        int t = fs.nextInt();
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while(t > 0){
            int n =fs.nextInt();
            pq.clear();
            
            for(int i = 0; i<n;i++){
                pq.offer(fs.nextLong());
            }
            long ret = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                ret += a + b;
                pq.offer(a+b);
            }
            sb.append(ret);    
            t--;
            if(t != 0){
                sb.append("\n");
            }
        }
        System.out.print(sb);
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
