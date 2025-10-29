import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,m;
    static ArrayList<Integer> adj[] = new ArrayList[1001];
    static int [] task = new int[1001];
    static int [] visited = new int[1001];
    
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
            for(int j = 0; j<2;j++){
                Arrays.fill(visited,0);
                if(canMatch(i)){
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
    
    static boolean canMatch(int person){
        for(int t : adj[person]){
            if(visited[t] == 1){
                continue;
            }
            visited[t] = 1;
            if(task[t] == person){
                continue;
            }
            if(task[t] == 0 || canMatch(task[t])){
                task[t] = person;
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
