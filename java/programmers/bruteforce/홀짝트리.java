import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adj = new ArrayList[1000004];
    static int[] visited  = new int[1000004];
    static int[] answer = new int[2];
    
    public int[] solution(int[] nodes, int[][] edges) {
        
        for(int node : nodes){
            adj[node] = new ArrayList<>();
        }
        for(int [] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        for(int node : nodes){
            if(visited[node] == 0){
                checkTree(node);
            }
        }
        return answer;
    }
    
    static void checkTree(int node){
        int hj = 0;
        int rhj = 0;
        Queue<Integer> q = new ArrayDeque<>();
        Queue<int[]> ret = new ArrayDeque<>();
        visited[node] = 1;
        q.offer(node);
        int cnt = 0;
        while(!q.isEmpty()){
            int pos = q.poll();
            cnt++;
            if(pos % 2 == adj[pos].size() % 2){ // 1 = 홀짝, 0 = 역홀짝
                ret.offer(new int[]{pos,1});
            }
            else{
                ret.offer(new int[]{pos,0});
            }
            if(pos % 2 == (adj[pos].size()-1) % 2){
                hj++;
            }
            else{
                rhj++;
            }
            for(int next : adj[pos]){
                if(visited[next] == 0){
                    visited[next] = 1;
                    q.offer(next);
                }
            }
        }
        while(!ret.isEmpty()){
            int []pos = ret.poll();
            if(pos[1] == 1 && hj == cnt-1){
                answer[0]++;
            }
            else if (pos[1] == 0 && rhj == cnt-1 ){
                answer[1]++;
            }
        }
    }
}
