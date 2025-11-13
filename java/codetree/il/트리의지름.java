import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<int[]> [] tree = new ArrayList[100004];
    static int [] visited = new int[100004];
    static int answer = 0;
    static int maxDist = 0;
    static int node;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i<100004;i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            tree[u].add(new int[]{v,w});
            tree[v].add(new int[]{u,w});
        }

        Arrays.fill(visited, 0);
        node = 1;
        dfs(1,0);
        maxDist = 0;
        Arrays.fill(visited, 0);
        dfs(node,0);
        System.out.print(maxDist);
    }

    static void dfs(int start,int dist){
        //System.out.println(start);
        visited[start] = 1;
        for(int [] next : tree[start]){
            //System.out.println(next[0] + " " + next[1] + " " + visited[next[0]]);
            if(visited[next[0]] == 1){
                continue;
            }
            dfs(next[0], dist + next[1]);
        }
        if(dist > maxDist){
            maxDist = dist;
            node = start;
        }
    }
}
