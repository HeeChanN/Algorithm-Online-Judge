import java.util.*;

class Solution {
    
    static class Edge{
        int u;
        int v;
        int w;
        
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    static List<Edge> edges = new ArrayList<>();
    static int [] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        
        for(int i = 0; i<costs.length;i++){
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(edges, Comparator.comparingInt((Edge e) -> e.w));
        parent = new int[n+1];
        
        for(int i = 0; i<n;i++){
            parent[i] = i;
        }
        
        for(Edge edge : edges){
            if(find(edge.u) != find(edge.v)){
                union(edge.u, edge.v);
                answer += edge.w;
                cnt++;
                if(cnt == n-1){
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px != py){
            parent[py] = px;
        }
    }
}
