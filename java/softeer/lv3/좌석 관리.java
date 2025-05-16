import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m,q;
    static int maxY = 21, maxX =21,dist = -1;

    static int [] seat = new int[10004];
    static Map<Integer, int[]> data = new HashMap< >();
    static int [][] arr = new int[24][24];
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        init();
        
        m = fs.nextInt();
        n = fs.nextInt();
        q = fs.nextInt();

        for(int i = 0; i<q; i++){
            String op = fs.next();
            int id = fs.nextInt();
            doTask(op,id);
        }
        System.out.print(sb);
    }

    static void doTask(String op, int id){
        if(op.equals("In")){
            inOperation(id);
        }
        else
            outOperation(id);
    }

    static void inOperation(int id){
        if(seat[id] == 1){
            sb.append(id).append(" already seated.\n");
            return;
        }
        if(seat[id] == 2){
            sb.append(id).append(" already ate lunch.\n");
            return;
        }

        refreshBestSeat();
        if(maxY == 21 && maxX == 21){
            sb.append("There are no more seats.\n");
            return;
        }

        seat[id] = 1;
        arr[maxY][maxX] = id;
        data.put(id,new int[]{maxY,maxX});
        arr[maxY][maxX] = id;
        sb.append(id).append(" gets the seat ")
            .append("(").append(maxX+1).append(", ").append(maxY+1).append(").\n");
    }

    static void outOperation(int id){
        if(seat[id] == 0){
            sb.append(id).append(" didn't eat lunch.\n");
            return;
        }
        if (seat[id] == 2){
            sb.append(id).append(" already left seat.\n");
            return;
        }
        seat[id] = 2;
        int[] pos = data.get(id);
        int y = pos[0];
        int x = pos[1];
        arr[y][x] = 0;
        data.remove(id);
        sb.append(id).append(" leaves from the seat ")
            .append("(").append(x+1).append(", ").append(y+1).append(").\n");
    }

    static void refreshBestSeat(){
        maxX = 21;
        maxY = 21;
        dist = -1;

        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j] != 0){
                    continue;
                }
                if (checkAround(i, j)) {
                    continue;
                }
                
                int d = calcSecurity(i,j);
                if(d > dist || d == dist && (j < maxX || j == maxX && i < maxY) ){
                    dist = d;
                    maxX = j;
                    maxY = i;
                }
            }
        }
    }

    static int calcSecurity(int y, int x){
        int d = 987654321;
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if (arr[i][j] == 0) 
                    continue;
                int pdist = (y-i)*(y-i) + (x-j)*(x-j);
                if(d > pdist){
                    d = pdist;
                }
                
            }
        }
        if(d == 987654321){
            return 0;
        }
        else
            return d;
    }

    static boolean checkAround(int y, int x){
        for(int i = 0; i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) 
                continue;
            if (arr[ny][nx] != 0) 
                return true;
        }
        return false;
    }
    
    static void init(){
        Arrays.fill(seat, 0);
        for(int row[] : arr){
            Arrays.fill(row,0);
        }
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
