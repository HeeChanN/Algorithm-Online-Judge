//https://www.acmicpc.net/problem/13334

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    static int n,d;
    
    static int idx = 0;
    static int ret = 0 ;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        List<int[]> arr = new ArrayList<>(n);
        for(int i = 0; i<n;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            int l = Math.min(a, b);
            int r = Math.max(a, b);
            arr.add(new int[]{l, r});
        }
        d = fs.nextInt();
        arr.sort(Comparator.comparingInt((int[] x) -> x[1])
                                .thenComparingInt(x -> x[0]));

        for(int [] cur : arr){
            int l = cur[0];
            int r = cur[1];
            
            if(r - d > l){
                continue;
            }
            
            pq.offer(l);
            
            int left = r - d;
            while(!pq.isEmpty() && pq.peek() < left){
                pq.poll();
            }
            ret = Math.max(ret, pq.size());
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
