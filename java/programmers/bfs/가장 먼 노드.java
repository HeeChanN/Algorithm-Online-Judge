import java.util.*;


class Solution {

    static ArrayList<Integer>[] graph = new ArrayList[20004];
    static int[] visited = new int[20004];
    
    public int solution(int n, int[][] edge) {
        init();
        for(int [] e : edge){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int dist = bfs();
        int answer = 0;
        for(int i = 0; i<20004;i++){
            if(visited[i] == dist){
                answer++;
            }
        }
        
        return answer;
    }
    
    static int bfs(){
        int maxDist = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = 1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer next : graph[node]){
                if(visited[next] == 0){
                    visited[next] = visited[node] + 1;
                    q.offer(next);
                }
                maxDist = Math.max(visited[next], maxDist);
            }
        }
        return maxDist;
    }
    
    static void init(){
        for(int i = 0; i<20004;i++){
            graph[i] = new ArrayList<>();
        }
    }
}
