import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adj = new ArrayList[1004]; 
    
    
    public static void main(String[] args) throws Exception{
        for(int i = 0; i<1004;i++){
            adj[i] = new ArrayList<>();
        }
        
        while(true){
            int n = fs.nextInt();
            if(n == 0){
                break;
            }
            int [][] arr = new int[n+1][2];
            int [] visited = new int[n+1];
            for (int i = 1; i <= n; i++) { 
                adj[i].clear();
            }
            Arrays.fill(visited, 1, n + 1, -1);

            for(int i = 1 ;i<=n;i++){
                char ch = fs.next().charAt(0);
                int cost = fs.nextInt();
                while(true){
                    int next = fs.nextInt();
                    if(next == 0){
                        break;
                    }
                    adj[i].add(next);
                }
                arr[i][0] = changeInfo(ch);
                arr[i][1] = cost;
            }
            
            // bfs 순회
            Queue<Integer> q = new ArrayDeque<>();
            if(arr[1][0] == 2){
                sb.append("No\n");
                continue;
            }
            else{
                visited[1] = arr[1][1];
                q.offer(1);
            }
            
            int flag = 0;
            while(!q.isEmpty()){
                int cur = q.poll();
                if(cur == n){
                    flag = 1;
                    break;
                }
                for(int next : adj[cur]){ // 다음 idx
                    int next_v = arr[next][0];
                    int next_cost = arr[next][1];
                    // System.out.println(next+ " : " +next_v + " " + next_cost);
                    if(next_v == 2 && visited[cur] - next_cost < 0){
                        continue;
                    }
                    if(next_v == 2){
                        next_cost = visited[cur] - next_cost;
                    }
                    else if (next_v == 1){
                        next_cost = Math.max(next_cost, visited[cur]);
                    }
                    else{
                        next_cost = visited[cur];
                    }
                    if(visited[next] >= next_cost){
                        continue;
                    }
                    q.offer(next);
                    visited[next] = next_cost;
                }
            }
            if(flag == 1){
                sb.append("Yes\n");
            }
            else{
                sb.append("No\n");
            }
        }
        System.out.print(sb);
    }
    
    static int changeInfo(char ch){
        if(ch == 'E'){
            return 0;
        }
        else if (ch == 'L'){
            return 1;
        }
        else{
            return 2;
        }
    }
    
    static void initAdj(){
        for(int i = 0; i<1004;i++){
            adj[i].clear();
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
    }
    
}
