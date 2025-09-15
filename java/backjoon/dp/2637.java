import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,m;
    static Set<Integer> s = new HashSet<>();
    static Map<Integer, int []> tools = new HashMap<>();
    static ArrayList<int[]> [] adj = new ArrayList[101];
    static int [] visited = new int [101];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<=n;i++){
            tools.put(i, new int[101]);
        }
        
        for(int i = 1 ; i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i =0 ; i<m;i++){
            int x = fs.nextInt();
            int y = fs.nextInt();
            int k = fs.nextInt();
            adj[x].add(new int[]{y,k});
        }
        go(n,0,0);
        int [] tmp = tools.get(n);
        ArrayList<Integer> basic = new ArrayList<>(s);
        Collections.sort(basic);
        for(int idx : basic){
            sb.append(idx).append(" ").append(tmp[idx]).append("\n");
        }
        System.out.print(sb);
    }
    
    static void go(int idx, int prev, int cnt){
        if(adj[idx].size() == 0){
            s.add(idx);
            int [] tmp = tools.get(prev);
            tmp[idx] += cnt;
            return;
        }
        if(visited[idx] == 1){
            int [] tmp = tools.get(prev);
            int [] plus = tools.get(idx);
            for(int i = 1;i<=n;i++){
                tmp[i] += plus[i] * cnt;
            }
            return;
        }
        for(int [] next : adj[idx]){
            go(next[0],idx, next[1]);
        }
        int [] tmp = tools.get(prev);
        int [] plus = tools.get(idx);
        for(int i = 1;i<=n;i++){
            tmp[i] += plus[i] * cnt;
        }
        visited[idx] = 1;
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
