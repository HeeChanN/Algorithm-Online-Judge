import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,k;
    static long ret = 0;
    
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        
        int cnt = 0;
        while(n>0){
            int needBuy = n % 2;
            if(needBuy == 1){
                pq.offer((long)Math.pow(2,cnt));
            }
            n = n/2;
            cnt++;
        }
        
        // while(!pq.isEmpty()){
        //     int a = pq.poll();
        //     System.out.println(a);
        // }
        while(true){
            if(pq.size() <= k){
                break;
            }
            long a = pq.poll();
            long b = pq.poll();
            ret += b - a;
            pq.offer(b + b);
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
    }
}
