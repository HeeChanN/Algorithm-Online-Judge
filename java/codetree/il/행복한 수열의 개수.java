import java.util.*;
import java.io.*;


// 연속하여 M개 이상의 동일한 원소가 나오는 수열
// 행, 열 -> 2N개의 수열
public class Main {

    static FastScanner fs = new FastScanner();
    static int [][] arr = new int[104][104];
    static int n,m;
    static int ret = 0;

    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i <n;i++){
            for(int j = 0; j<n;j++){
                arr[i][j] = fs.nextInt();
            }
        }

        checkCol();
        checkRow();

        System.out.print(ret);
    }

    static void checkRow(){
        // 행
        for(int i = 0; i<n;i++){
            // 좌표
            int cnt = 1; 
            int pos = 0;
            while(true){
                int next = pos + 1;
                if(cnt >= m){
                    ret++;
                    break;
                }
                if(next >= n){
                    break;
                }
                if(arr[i][next] == arr[i][pos]){
                    cnt++;
                }
                else{
                    cnt = 1;
                }
                pos = next;
            }
        }
    }

    static void checkCol(){
        // 열
        for(int i = 0; i<n;i++){
            // 좌표
            int cnt = 1; 
            int pos = 0;
            while(true){
                int next = pos + 1;
                if(cnt >= m){
                    ret++;
                    break;
                }
                if(next >= n){
                    break;
                }
                if(arr[next][i] == arr[pos][i]){
                    cnt++;
                }
                else{
                    cnt = 1;
                }
                pos = next;
            }
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
