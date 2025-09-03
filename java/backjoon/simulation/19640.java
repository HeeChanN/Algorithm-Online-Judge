import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m,k;
    
    static Queue<int[]>[] q = new ArrayDeque[100004];
    
    static Comparator<int[]> cmp =
    Comparator.<int[]>comparingInt(x -> x[0]).reversed()
      .thenComparing(Comparator.comparingInt((int[] x) -> x[1]).reversed())
      .thenComparingInt(x -> x[3]); 

    static PriorityQueue<int[]> pq = new PriorityQueue<>(
        cmp
    );
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 1; i<100004;i++){
            q[i] = new ArrayDeque<>();
        }
        
        int c = 1;
        for(int i = 1;i<=n;i++){
            int d = fs.nextInt();
            int h = fs.nextInt();
            q[c].offer(new int[]{d,h,i});
            c++;
            if(c == m+1){
                c = 1;
            }
        }
        
        
        for(int i = 1;i<=m;i++){
            if(q[i].isEmpty()){
                continue;
            }
            int [] cur = q[i].poll();
            pq.offer(new int[]{cur[0], cur[1], cur[2], i});
        }
        
        int ret = 0;
        while(true){
            int [] cur = pq.poll();
            if(cur[2] == k+1){
                break;
            }
            ret++;
            if(q[cur[3]].isEmpty()){
                continue;
            }
            int []next = q[cur[3]].poll();
            pq.offer(new int[]{next[0], next[1],next[2],cur[3]});
        }
            
        System.out.print(ret);
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
