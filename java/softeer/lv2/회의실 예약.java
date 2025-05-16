import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m,s,e;
    static int roomCnt = 0;
    static String str;

    static Map<String, Integer> mp = new TreeMap<>();
    static boolean [][] visited = new boolean[54][20];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0;i<n;i++){
            str = fs.next();
            mp.put(str,i);
            visited[i][18] = true;
        }
        for(int i = 0; i<m;i++){
            str = fs.next();
            s = fs.nextInt();
            e = fs.nextInt();
            int idx = mp.get(str);
            for(int j = s;j<e;j++){
                visited[idx][j] = true;
            }
        }

        
        for(Map.Entry<String,Integer> e : mp.entrySet()){
            roomCnt++;
            sb.append("Room ").append(e.getKey()).append(":\n");
            StringBuilder a = new StringBuilder();
            int cnt = 0;
            int idx = e.getValue();
            int i = 9;
            int l = i;
            int r = i;
            while(i <= 18){
                if(visited[idx][i] == true){
                    if(l != r){
                        a.append(String.format("%02d",l)).append("-").append(r).append("\n");
                        cnt++;
                    }
                    i++;
                    l = i;
                    r = i;
                    continue;
                }
                i++;
                r = i;
            }
            if(cnt == 0){
                sb.append("Not available\n");
            }
            else{
                sb.append(cnt).append(" available:\n").append(a);
            }
            if(roomCnt != n){
                sb.append("-----\n");
            }
        }
        System.out.print(sb);
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
