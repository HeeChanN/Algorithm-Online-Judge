import java.util.*;

class Solution {
    
    static ArrayList<Integer> [] adj = new ArrayList[100004];
    static int [] visited = new int[100004];
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.fill(visited, 987654321);
        for(int i = 0; i<100004;i++){
            adj[i] = new ArrayList();
        }
        for(int []road : roads){
            int a = road[0];
            int b = road[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        bfs(destination);
        for(int source : sources){
            if(visited[source] == 987654321){
                answer.add(-1);
            }
            else
                answer.add(visited[source]);
        }
        
        return answer.stream().mapToInt(o->o.intValue())
            .toArray();
    }
    
    static void bfs(int destination){
        Queue<Integer> q = new ArrayDeque<>();
        visited[destination] = 0;
        q.offer(destination);
        while(!q.isEmpty()){
            int p = q.poll();
            for(int next : adj[p]){
                if(visited[next] > visited[p] + 1){
                    visited[next] = visited[p] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
