import java.util.*;
import java.io.*;


// n X n 격자
// 3 * 3 크기의 격자를 적절하게 잘 잡아서 해당 범위 안에 들어있는 동전의 개수를 최대로 하
public class Main {
    
    static FastScanner fs = new FastScanner();
    static int [][] arr = new int[24][24];
    static int ret = 0;

    public static void main(String[] args) throws Exception{
        int n = fs.nextInt();

        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                arr[i][j] = fs.nextInt();
            }
        }    
        for(int i = 0; i<n-2;i++){
            for(int j = 0; j<n-2;j++){
                check3x3(i,j);
            }
        }
        System.out.print(ret);
    }

    static void check3x3(int y, int x){
        int cnt = 0;
        for(int i = y; i<y +3;i++){
            for(int j = x; j<x +3;j++){
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        ret = Math.max(ret,cnt);
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
