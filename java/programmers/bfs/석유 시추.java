import java.util.*;

// 0 ~ m-1까지 순회하며 각 col의 모든 row를 bfs() 순회하여 총 석유량 구하고
// 최대 총 석유량에 해당하는 값 기록 및 return
// 0 이면 빈 땅, 1이면 석유가 있는 땅


// 1. 모든 격자 순회하며 bfs 돌려서 석유가 존재하는 칸에 해당 영역의 idx 적어두기
// 2. col 순회하며 각 row를 순회할 때 속한 포함된 영역을 바탕으로 총 석유량 구하기

class Solution {
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static int n,m;
    static int answer = 0;
    static int[][] visited = new int[504][504];
    static int[][] board;
    
    static int idx = 1;
    static Map<Integer, Integer> amount = new HashMap<>();
    
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        board = new int[n+1][m+1];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                board[i][j] = land[i][j];
            }
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    bfs(i,j);
                    idx++;
                }
            }
        }
        
        for(int i = 0;i<m;i++){
            int cnt = 0;
            Set<Integer> s = new HashSet<>();
            for(int j = 0; j<n;j++){
                if(visited[j][i] != 0){
                    s.add(visited[j][i]);
                }
            }
            for(Integer a : s){
                cnt += amount.get(a);
            }
            answer = Math.max(answer,cnt);
        }

        
        return answer;
    }
    
    static void bfs(int y, int x){
        visited[y][x] = idx;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        int cnt = 1;
        
        while(!q.isEmpty()){
            int [] p = q.poll();
            int py = p[0];
            int px = p[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >=m || board[ny][nx] == 0){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = idx;
                    q.offer(new int[]{ny,nx});
                    cnt++;
                }
            }
        }
        amount.put(idx,cnt);
    }
    static void print(){
        for(Map.Entry<Integer, Integer> e : amount.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
