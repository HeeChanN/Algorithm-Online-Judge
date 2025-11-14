import java.util.*;
public class Main {

    static ArrayList<Integer> [] tree = new ArrayList[54];
    static int deleteNode;
    static int n,root;       
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int parent;
        n = sc.nextInt();
        for(int i = 0; i<n;i++){
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            parent = sc.nextInt();
            if(parent == -1){
                root = i;
                continue;
            }
            tree[parent].add(i);
        }
        deleteNode = sc.nextInt();
        dfs(root);
        System.out.print(ret);
    }

    static void dfs(int node){
        if(node == deleteNode){
            return;
        }
        
        int cnt = 0;
        for(int next : tree[node]){
            if(next == deleteNode){
                continue;
            }
            cnt++;
            dfs(next);
        }
        if(cnt == 0){
            ret++;
        }
    }
}
