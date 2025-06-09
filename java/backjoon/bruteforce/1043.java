import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m,know,tmp;
    static int ret = 0;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] visited = new int[54];
    static int[] partyCheck = new int[54];
    static ArrayList<Integer> [] party = new ArrayList[54];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        know = fs.nextInt();
        for(int i = 0; i<know;i++){
            tmp = fs.nextInt();
            q.offer(tmp);
            visited[tmp] = 1;
        }
        for(int i = 0;i<m;i++){
            party[i] = new ArrayList<>();
            int c = fs.nextInt();
            for(int j = 0; j<c;j++){
                tmp = fs.nextInt();
                party[i].add(tmp);
            }
        }
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i =0;i<m;i++){
                int flag = 0;
                if(partyCheck[i] == 1){
                    continue;
                }
                for(int f : party[i]){
                    if(f == p){
                        flag = 1;
                    }
                }
                if(flag == 1){
                    for(int f : party[i]){
                        if(visited[f] == 0){
                            q.offer(f);
                            visited[f] = 1;
                        }
                    }
                    partyCheck[i] = 1;
                }
            }
        }
        for(int i = 0; i<m;i++){
            if(partyCheck[i] == 0){
                ret++;
            }
        }
        System.out.print(ret);
    }

    static class FastScanner{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
