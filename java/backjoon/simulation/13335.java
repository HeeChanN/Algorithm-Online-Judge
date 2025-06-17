import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] bridge;
    
    static int n,w,l,truck;
    static int cnt = 0;
    static int sum = 0;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        w = fs.nextInt();
        l = fs.nextInt();
        
        bridge = new int[w+1];
        
        for(int i = 0; i<n;i++){
            truck = fs.nextInt();
            q.offer(truck);
        }
        
        while(!q.isEmpty()){
            cnt++;
            moveTruck();
            int nextTruck = q.peek();
            if(nextTruck + sum > l){
                continue;
            }
            q.poll();
            bridge[w-1] = nextTruck;
            sum += nextTruck;
        }
        
        for(int i = w-1;i>=0;i--){
            if(bridge[i] != 0){
                cnt += i;
                break;
            }
        }
        System.out.print(cnt+1);
    }
    
    static void moveTruck(){
        for(int i = 0; i<w;i++){
            if(i == 0){
                sum = sum - bridge[i];
                bridge[i] = 0;
            }
            else{
                bridge[i-1] = bridge[i];
                bridge[i] = 0;
            }
        }
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
        
        String nextLine() throws Exception { 
            return br.readLine(); 
        }
    }
}
