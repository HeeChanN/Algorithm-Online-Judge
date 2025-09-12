import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static ArrayList<Integer>[] tree = new ArrayList[54];
    static int [] dp = new int[54];
    
    static int n;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<54;i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i =0 ; i<n;i++){
            int parent = fs.nextInt();
            if(parent == -1){
                continue;
            }
            tree[parent].add(i);
        }
        
        Arrays.fill(dp, -1);
        System.out.print(go(0));
        
    }
    
    static int go(int idx){
        if(tree[idx].size() == 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.comparingInt((Integer a) -> -a ));
        for(int child : tree[idx]){
            pq.offer(go(child));
        }
        for(int i = 1; i<=tree[idx].size();i++){
            dp[idx] = Math.max(dp[idx], i+pq.poll());
        }
        return dp[idx];
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
