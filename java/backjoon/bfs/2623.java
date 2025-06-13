import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int num, n, m;
    static int tmp;
    
    static ArrayList<Integer>[] adj = new ArrayList[1004];
    static int[] need = new int[1004];
    static ArrayList<Integer> v =new ArrayList<>();
    static int[] arr = new int[1004];
    
    public static void main(String[] args) throws Exception{
       n = fs.nextInt();
       m = fs.nextInt();
       for(int i = 1; i<=n;i++){
           adj[i] = new ArrayList<>();
       }
       
       for(int i = 0; i<m;i++){
           num = fs.nextInt();
           
           for(int j=0;j<num;j++){
               arr[j] = fs.nextInt();
           }
           for(int j = 0; j<num-1;j++){
               adj[arr[j]].add(arr[j+1]);
               need[arr[j+1]]++;
           }
       }
       Queue<Integer> q = new ArrayDeque<>();
       for(int i = 1; i<=n;i++){
           if(need[i] == 0){
               q.offer(i);
           }
       }
       int cnt = 0;
       while(!q.isEmpty()){
           int p = q.poll();
           sb.append(p).append("\n");
           cnt++;
           for(int next : adj[p]){
               need[next]--;
               if(need[next] == 0){
                   q.offer(next);
               }
           }
       }
       
       if(cnt == n){
           System.out.print(sb);
       }
       else{
           System.out.print(0);
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
