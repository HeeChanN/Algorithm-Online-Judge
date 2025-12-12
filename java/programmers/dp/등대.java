import java.util.*;


// 1 ~ n 서로 다른 번호 등대
// 뱃길 n-1개, 어느 등대에서 출발해도 다른 모든 등대 까지 이동 가능
// 한 뱃길의 양쪽 끝 등대 중 적어도 하나는 켜져 있도록 등대를 켜두어야 한다.

// 켜두어야 하는 등대 개수의 최솟값 구하기
// 등대의 개수 n <= 10만

// 그래프, 간선이 n-1개

class Solution {
    
    static ArrayList<Integer> adj[] = new ArrayList[100004];
    static int [][] dp = new int[100004][2];
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        for(int i = 0; i<100004;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n-1;i++){
            int u = lighthouse[i][0];
            int v = lighthouse[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int [] parent = new int[100004];
        int [] order = new int[100004];
        int ordIdx = 0;
        
        stack.push(1);
        parent[1] = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            order[ordIdx++] = u;
            
            for(int v : adj[u]){
                if(parent[u] == v){
                    continue;
                }
                parent[v] = u;
                stack.push(v);
            }
        }
        
        for(int i = n-1; i>=0; i--){
            int u = order[i];
            
            dp[u][0] = 0;
            dp[u][1] = 1;
            
            for(int v : adj[u]){
                if(parent[u] == v){
                    continue;
                }
                dp[u][0] += dp[v][1];
                dp[u][1] += Math.min(dp[v][1], dp[v][0]);
            }
        }
        
        return Math.min(dp[1][0], dp[1][1]);
    }
}
