import java.util.*;

public class Main {

    static ArrayList<int[]> graph[]= new ArrayList[504];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ret = 0;
        int cnt = 0;

        for(int i = 0; i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        
        // 시작 지점 = 1번 노드

        PriorityQueue<int []> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[]a)->a[1])
        );
        int [] visited = new int[n+1];
        pq.offer(new int[]{1,0});

        while(!pq.isEmpty()){
            int [] cur = pq.poll();

            int v = cur[0];
            int w = cur[1];

            if(visited[v] != 0){
                continue;
            }

            visited[v] = 1;
            ret += w;
            cnt++;

            if(cnt == n){
                break;
            }

            for(int [] next : graph[v]){
                if(visited[next[0]] != 0){
                    continue;
                }
                pq.offer(new int[]{next[0], next[1]});
            }
        }
        System.out.print(ret);
    }
}
