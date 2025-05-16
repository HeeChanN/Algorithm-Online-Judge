import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<int []> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(b[0],a[0])
    );
    
    public static void main(String[] args) throws Exception{
        int w = fs.nextInt();
        int n = fs.nextInt();
        int ret = 0;
        for(int i = 0; i<n;i++){
            int m = fs.nextInt();
            int p = fs.nextInt();
            pq.offer(new int[]{p,m});
        }
        while(!pq.isEmpty()){
            int [] pos = pq.poll();
            if(pos[1]<=w){
                w = w - pos[1];
                ret = ret + pos[0] * pos[1];
            }
            else{
                ret = ret + w * pos[0];
                break;
            }
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
