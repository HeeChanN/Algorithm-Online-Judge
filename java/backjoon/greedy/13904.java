import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static ArrayList<int[]> task = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        int n = fs.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> a));
        for(int i = 0; i<n;i++){
            int d = fs.nextInt();
            int w = fs.nextInt();
            task.add(new int[]{d,w});
        }
        Collections.sort(task, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> -a[1]));
        
        // pq의 size는 day 크기만큼 유지하기
        int day = 1;
        int idx = 0;
        while(true){
            for(; idx<n;idx++){
                int [] cur = task.get(idx);
                if(cur[0] > day){
                    break;
                }
                pq.offer(cur[1]);
            }
            while(pq.size()>day){
                pq.poll();
            }
            if(idx == n){
                break;
            }
            day++;
        }
        int ret = 0;
        while(!pq.isEmpty()){
            ret += pq.poll();
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
