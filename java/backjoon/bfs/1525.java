// https://www.acmicpc.net/problem/1525
import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int [][] board = new int[3][3];
    static int y,x;
    static Map<String,Integer> mp = new HashMap<>();
    
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                sb.append(fs.nextInt());
            }
        }
        bfs(sb.toString());
        if(mp.containsKey("123456780")){
            System.out.print(mp.get("123456780"));
        }
        else{
            System.out.print("-1");
        }
    }
    
    static void bfs(String s){
        Queue<String> q = new ArrayDeque<>();
        q.offer(s);
        mp.put(s, 0);
        while(!q.isEmpty()){
            String p = q.poll();
            int idx = p.indexOf('0');
            int py = idx / 3;
            int px = idx % 3;
            for(int i = 0;i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=3 || nx >= 3){
                    continue;
                }
                String nextStr = swap(py,px,ny,nx, p);
                if(!mp.containsKey(nextStr)){
                    mp.put(nextStr, mp.get(p) + 1);
                    q.offer(nextStr);
                }
                if(nextStr.equals("123456780")){
                    return;
                }
            }
        }
    }
    
    static String swap(int ty,int tx, int vy, int vx, String v){
        char [] tmp = v.toCharArray();
        char a = tmp[ty * 3 + tx];
        tmp[ty * 3 + tx] = tmp[vy * 3 + vx];
        tmp[vy * 3 + vx] = a;
        return new String(tmp);
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
