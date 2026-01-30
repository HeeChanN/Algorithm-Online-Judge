import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,t,w,m;
    static Queue<int[]> q = new ArrayDeque<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int []a) -> a[0])    
    );
    static ArrayList<int []> ret = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        t = fs.nextInt();
        w = fs.nextInt();
        for(int i = 0; i<n;i++){
            int id = fs.nextInt();
            int time = fs.nextInt();
            q.offer(new int[]{id, time});
        }
        
        m = fs.nextInt();
        for(int i = 0;i<m;i++){
            int id = fs.nextInt();
            int time = fs.nextInt();
            int c = fs.nextInt();
            
            pq.offer(new int[]{c,id,time});
        }
        
        // 시뮬레이션 시작
        int baseTime = 0; // 시작시간
        while(true){
            // 1. 맨앞 손님 작업 처리하기
            int [] customer = q.poll();
            
            // 2. 작업시간 만큼 현재 시간 기록
            if(customer[1] <= t){
                baseTime += customer[1];
                // baseTime을 기준으로 손님 pq -> q로 옮기기
                reducePQ(baseTime);
            }
            else{
                baseTime += t;
                customer[1] -= t;
                reducePQ(baseTime);
                q.offer(customer);
            }
            ret.add(new int[]{baseTime,customer[0]});
            if(baseTime >= w){
                break;
            }
        }
        int currentTime = 0;
        for(int [] a : ret){
            int limit = Math.min(a[0], w);
            while(currentTime < limit){
                sb.append(a[1]).append("\n");
                currentTime++;
            }
            if(limit == w){
                break;
            }
        }
        System.out.print(sb);
    }
    
    static void reducePQ(int base){
        while(!pq.isEmpty()){
            int [] cur = pq.peek();
            if(cur[0] > base){
                break;
            }
            q.offer(new int[]{cur[1], cur[2]});
            pq.poll();
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
