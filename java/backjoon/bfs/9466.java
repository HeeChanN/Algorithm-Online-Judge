import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int t,n;
    static int [] arr = new int[100004];
    static int [] visited = new int[100004];
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int i = 0; i<t;i++){
            n = fs.nextInt();
            for(int j = 1; j<=n;j++){
                arr[j] = fs.nextInt();
                if(j == arr[j]){
                    visited[j] = j;
                    cnt++;
                }
            }
            for(int j = 1; j<=n;j++){
                if(visited[j] == 0){
                    bfs(j);
                }
            }
            
            sb.append(n-cnt).append("\n");
            cnt = 0;
            Arrays.fill(visited, 0);
        }
        System.out.print(sb);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = start;
        
        while(!q.isEmpty()){
            int p = q.poll();
            int next = arr[p];
            if(visited[next] == 0){
                q.offer(next);
                visited[next] = start;
            }
            else if (visited[next] == start){
                // 사이클 존재 -> next부터 사이클에 포함되는 노드 개수 세기
                int num = next;
                int cycle = 1;
                while(true){
                    num = arr[num];
                    if(num == next){
                        cnt+=cycle;
                        return;
                    }
                    cycle++;
                }
            }
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
}import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int t,n;
    static int [] arr = new int[100004];
    static int [] visited = new int[100004];
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int i = 0; i<t;i++){
            n = fs.nextInt();
            for(int j = 1; j<=n;j++){
                arr[j] = fs.nextInt();
                if(j == arr[j]){
                    visited[j] = j;
                    cnt++;
                }
            }
            for(int j = 1; j<=n;j++){
                if(visited[j] == 0){
                    bfs(j);
                }
            }
            
            sb.append(n-cnt).append("\n");
            cnt = 0;
            Arrays.fill(visited, 0);
        }
        System.out.print(sb);
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = start;
        
        while(!q.isEmpty()){
            int p = q.poll();
            int next = arr[p];
            if(visited[next] == 0){
                q.offer(next);
                visited[next] = start;
            }
            else if (visited[next] == start){
                // 사이클 존재 -> next부터 사이클에 포함되는 노드 개수 세기
                int num = next;
                int cycle = 1;
                while(true){
                    num = arr[num];
                    if(num == next){
                        cnt+=cycle;
                        return;
                    }
                    cycle++;
                }
            }
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
