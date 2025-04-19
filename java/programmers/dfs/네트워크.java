import java.util.*;

class Solution {
    
    static int [] visited = new int[204];
    static int s;
    static int [][] board;
    static List<Integer> [] graph = new ArrayList[204];
    
    
    static void dfs(int pos){
        visited[pos] = 1;
        for(int a : graph[pos]){
            if(visited[a] == 0){
                dfs(a);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        s = n;
        board = computers;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(computers[i][j] == 1){
                    if(i != j){
                        graph[i].add(j);
                        graph[j].add(i);   
                    }
                    else{
                        graph[i].add(j);
                    }
                }
            }
        }
        for(int i = 0; i<n;i++){
            if(visited[i] == 0){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}