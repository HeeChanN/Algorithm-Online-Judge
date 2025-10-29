import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,m;
    static ArrayList<Integer> adj[] = new ArrayList[204];
    static int [] match = new int[204];
    static int [] visited = new int[204];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i =1; i<=n;i++){
            adj[i] = new ArrayList<>();
            int num = fs.nextInt();
            for(int j = 0; j<num;j++){
                adj[i].add(fs.nextInt());
            }
        }
        
        int ret = 0 ;
        for(int i = 1; i<=n;i++){
            Arrays.fill(visited,0);
            if(bfs(i)){
                ret++;
            }
        }
        System.out.println(ret);
    }
    
    static boolean bfs(int cow){
        
        for(int target : adj[cow]){
            if(visited[target] == 1){
                continue;
            }
            visited[target] = 1;
            if(match[target] == 0 || bfs(match[target])){
                match[target] = cow;
                return true;
            }
        }
        return false;
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
