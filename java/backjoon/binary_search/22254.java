import java.util.*;
import java.io.*;

class Main {
    
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
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static ArrayList<Integer> arr=  new ArrayList<>();
    static int ret = 987654321;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0;i <n;i++){
            arr.add(fs.nextInt());
        }
        
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> -a));
            int flag = 1;
            for(int i = 0; i<mid;i++){
                pq.add(m);
            }
            for(int i = 0;i<n;i++){
                int cur = pq.poll();
                if(cur >= arr.get(i)){
                    cur -=arr.get(i);
                    pq.offer(cur);
                }
                else{
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                left = mid + 1;
            }
            else{
                ret = Math.min(ret, mid);
                right = mid - 1;
            }
        }
        System.out.print(ret);
    }
}
