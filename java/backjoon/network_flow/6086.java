import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int [][] flow = new int[52][52];
    static int [][] capacity = new int[52][52];
    static ArrayList<Integer> adj[] = new ArrayList[52];
    static int n;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<52;i++){
            adj[i] = new ArrayList<>();
        }
        
        // 용량 포함 양방향 네트워크 -> 인접리스트 + 이차원 배열
        for(int i =0 ; i<n;i++){
            int u = atoi(fs.next().charAt(0));
            int v = atoi(fs.next().charAt(0));
            int c = fs.nextInt();
            
            capacity[u][v] += c;
            capacity[v][u] += c;
            adj[u].add(v);
            adj[v].add(u);
        }
       
       int ret = maxFlow(0,25); // -> 출발점 -> 목적지까지 최대 유량 구하기
       System.out.print(ret);
    }
    
    static int maxFlow(int src, int sink){
        int totalFlow = 0;
        int [] parent = new int[52];
        // 반복해서 증가경로 찾기
        while(true){
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            
            q.offer(src);
            parent[src] = src;
            
            // sink에 유량이 도달하는 증가 경로를 찾았다면 그만하기 또는 더이상 없다면 그만하기 
            // 경로 탐색 중 c - f = r 로 잔여 용량을 보낼 수 있으면 보내기
            while(!q.isEmpty() && parent[sink] == -1){
                int cur = q.poll();
                for(int next : adj[cur]){
                    if(parent[next] == -1 && capacity[cur][next] - flow[cur][next] > 0){
                        q.offer(next);
                        parent[next] = cur;
                    }
                }
            }
            
            // 더이상 증가 경로가 없는 경우
            if(parent[sink] == -1){
                break;
            }
            
            // parent -> src를 순회하며 보낼 수 있는 유량 정하기
            int amount = Integer.MAX_VALUE;
            for(int i = sink; i != src; i = parent[i]){
                amount = Math.min(amount, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            
            // flow 최신화 해주기
            for(int i = sink; i != src; i = parent[i]){
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }
            totalFlow += amount;
        }
        return totalFlow;
    }
    
    static int atoi(char ch){
        if('A' <= ch && ch <= 'Z'){
            return ch - 'A';
        }
        else if('a' <= ch && ch <= 'z'){
            return ch - 'A' - 6;
        }
        return -1;
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
