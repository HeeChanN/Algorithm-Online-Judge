import java.util.*;
import java.io.*;


// n * m 크기의 이차원 영역의 각 위치에 자연수가 하나 씩 적힘
// 2가지 종류의 블럭 중 한개를 블럭이 격자 벗어나지 않도록
// 블록이 놓인 칸 안에 적힌 숫자의 합이 최대
public class Main {

    static FastScanner fs = new FastScanner();
    
    static int [][] arr = new int[204][204];
    static int ret = 0;
    static int n,m;

    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();

        for(int i =0 ; i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = fs.nextInt();
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                checkLineBlock(i,j);
            }
        }

        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                checkEdgeBlock(i,j);
            }
        }

        System.out.print(ret);
    }
    // 2번 확인, 가로, 세로 
    static void checkLineBlock(int y, int x){
        if( (y+1) < n && (y + 2) <n){
            ret = Math.max(ret, arr[y][x] + arr[y+1][x] + arr[y+2][x]);
        }
        if((x+1) < m && (x + 2) <m){
            ret = Math.max(ret, arr[y][x] + arr[y][x+1] + arr[y][x+2]);
        }
    }

    static void checkEdgeBlock(int y, int x){
        if(y - 1 >= 0 && x - 1 >= 0){
            ret = Math.max(ret, arr[y][x] + arr[y-1][x] + arr[y][x-1]);
        }
        if(y - 1 >= 0 && x + 1 < m){
            ret = Math.max(ret, arr[y][x] + arr[y-1][x] + arr[y][x+1]);
        }
        if(y + 1 < n && x - 1 >= 0){
            ret = Math.max(ret, arr[y][x] + arr[y+1][x] + arr[y][x-1]);
        }
        if(y + 1 < n && x + 1 < m){
            ret = Math.max(ret, arr[y][x] + arr[y+1][x] + arr[y][x+1]);
        }
    }

    static class FastScanner {
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
