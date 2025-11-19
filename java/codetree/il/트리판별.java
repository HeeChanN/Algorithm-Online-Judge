import java.util.*;

public class Main {
    
    static ArrayList<Integer> [] tree = new ArrayList[10004];
    static boolean [] visited = new boolean[10004];
    static Set<Integer> nodes = new HashSet<>();

    static int rootNode;
    static int ret = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        for(int i = 0; i<10004;i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            nodes.add(a);
            nodes.add(b);
        }

        for(int node : nodes){
            for(int nextNode : tree[node]){
                visited[nextNode] = true;
            }
        }
        for(int node : nodes){
            if(visited[node] == false){
                rootNode = node;
            }
        }
        Arrays.fill(visited, false);
        
        dfs(rootNode);
        for(int node : nodes){
            if(visited[node] == false){
                ret = 0;
                break;
            }
        }
        System.out.print(ret);
    }

    static void dfs(int pos){
        visited[pos] = true;
        for(int nextNode : tree[pos]){
            if(visited[nextNode]){
                ret = 0;
                return ;
            }
            dfs(nextNode);
        }
    }
}
