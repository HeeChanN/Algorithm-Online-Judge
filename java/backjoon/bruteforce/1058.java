import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int ret = 0;
    static ArrayList<Integer>[] adj = new ArrayList[54];
    static int [] visited = new int[54];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<n;i++){
            String friend = fs.next();
            for(int j = 0; j<friend.length();j++){
                if(friend.charAt(j) == 'Y'){
                    adj[i].add(j);
                }
            }
        }
        
        for(int i = 0; i<n;i++){
            int cnt = count2Friend(i);
            ret = Math.max(cnt, ret);
            Arrays.fill(visited, 0);
        }
        System.out.print(ret);
    }
    
    static int count2Friend(int idx){
        int cnt = 0;
        visited[idx] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        for(int next : adj[idx]){
            if(visited[next] == 0){
                q.offer(next);
                cnt++;
                visited[next] = 1;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                if(visited[next] == 0){
                    cnt++;
                    visited[next] = 1;
                }
            }
        }
        return cnt;
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
