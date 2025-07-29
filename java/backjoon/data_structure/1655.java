import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int [] arr = new int[100004];
    
    static int n,mid;
    static PriorityQueue<Integer> l = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
    static PriorityQueue<Integer> r = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        
        for(int i = 0; i <n;i++){
            arr[i] = fs.nextInt();
        }
        mid = arr[0];
        sb.append(mid).append("\n");
        for(int i = 1; i<n;i++){
            if(mid > arr[i]){
                l.offer(arr[i]);
            }
            else{
                r.offer(arr[i]);
            }
            calc();
            sb.append(mid).append("\n");
        }
        System.out.print(sb);
    }
    
    static void calc(){
        if(l.size() > r.size()){
            int tmp = l.poll();
            r.offer(mid);
            mid = tmp;
        }
        else if(l.size() + 1 < r.size()){
            int tmp = r.poll();
            l.offer(mid);
            mid = tmp;
        }
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
