import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static ArrayList<int[]> arr = new ArrayList<>();
    
    static PriorityQueue<int[]> using = new PriorityQueue<>(
        Comparator.comparingInt((int[]a)->a[0]));
    static PriorityQueue<Integer> seat = new PriorityQueue<>(
        Comparator.comparingInt((Integer a) -> a));
    
    static int[] cnt = new int[100004];
    static int ret = 0;
    static int idx = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            int s = fs.nextInt();
            int e = fs.nextInt();
            arr.add(new int[]{s,e});
        }
        arr.sort(
            Comparator.comparingInt((int[] a) -> a[0])
        );
        // 좌석 번호 관리
        for(int i = 0; i<1000000;i++){
            seat.offer(i);
        }
        
        for(int i = 0; i<1000000;i++){
            if(idx == n){
                break;
            }
            leaveComputer(i);
            enterComputer(i);
        }
        sb.append(ret).append("\n");
        for(int i = 0; i<ret;i++){
            sb.append(cnt[i] + " ");
        }
        System.out.print(sb);
    }
    
    static void leaveComputer(int time){
        if(!using.isEmpty() && using.peek()[0] == time){
            int [] cur = using.poll();
            seat.offer(cur[1]);
        }
    }
    
    static void enterComputer(int time){
        int [] cur = arr.get(idx);
        int startTime = cur[0];
        int endTime = cur[1];
        if(time == startTime){
            int chair = seat.poll();
            using.offer(new int[]{endTime, chair});
            cnt[chair]++;
            idx++;
            ret = Math.max(ret, using.size());
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
