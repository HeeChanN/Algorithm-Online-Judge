import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,k;
    static int v,u;
    static ArrayList<Integer>[] adj = new ArrayList[402];
    static Set<Integer>[] s = new HashSet[402];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        for(int i = 0; i<=n;i++){
            adj[i] = new ArrayList<>();
            s[i] = new HashSet<>();
        }
        
        for(int i = 0; i<k;i++){
            v = fs.nextInt();
            u = fs.nextInt();
            adj[u].add(v);
        }
        
        for(int i = 1; i<=n;i++){
            bfs(i);
        }
        
        int t = fs.nextInt();
        
        for(int i = 0; i<t;i++){
            v = fs.nextInt();
            u = fs.nextInt();
            if(s[v].contains(u)){
                sb.append("1\n");
            }
            else if(s[u].contains(v)){
                sb.append("-1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int pos = q.poll();
            for(int next : adj[pos]){
                if(!s[start].contains(next)){
                    s[start].add(next);
                    q.offer(next);
                }
            }
        }
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
