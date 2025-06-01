import java.util.*;
import java.io.*;

// 볼 옮기기
// 총 볼의 개수 1 <= N <= 50만 
// R, B

// 바로 옆에 다른 색깔의 볼이 있으면 그 볼을 모두 뛰어 넘어 옮길 수 있다.

// 한 색을 고르면 그색만 

// 양 옆의 연속 구간을 구하기
// 왼쪽은 B 2개 오른쪽은 R 1개일때
// B의 나머지를 움직여야하고
// R의 나머지를 음직여야함

// RRRRRR
// RRBB
//RRRRRRRRBBBRRRR
// 왼쪽 R, 오른쪽 R
// 왼쪽 B, 오른쪽 B


class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static String str;
    static int ret = 987654321;
    static int cnt = 0;
    static char[] c = new char[500004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        str = fs.next();
        int rCnt = 0;
        int bCnt = 0;
        for(int i = 0; i<str.length();i++){
            c[i] = str.charAt(i);
            if(c[i] == 'R'){
                rCnt++;
            }
            else{
                bCnt++;
            }
        }
        int leftRCnt = 0;
        int leftBCnt = 0;
        int rightRCnt = 0;
        int rightBCnt = 0;
        for(int i =0;i<n;i++){
            if(c[i] == 'B'){
                break;
            }
            leftRCnt++;
        }
        for(int i =0;i<n;i++){
            if(c[i] == 'R'){
                break;
            }
            leftBCnt++;
        }
        for(int i =n-1;i>=0;i--){
            if(c[i] == 'B'){
                break;
            }
            rightRCnt++;
        }
        for(int i =n-1;i>=0;i--){
            if(c[i] == 'R'){
                break;
            }
            rightBCnt++;
        }
        ret = Math.min(ret, rCnt - leftRCnt);
        ret = Math.min(ret, bCnt - leftBCnt);
        ret = Math.min(ret, rCnt - rightRCnt);
        ret = Math.min(ret, bCnt - rightBCnt);
        
        
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
