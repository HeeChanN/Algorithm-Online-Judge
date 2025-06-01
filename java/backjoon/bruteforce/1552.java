import java.io.*;
import java.util.*;

// a,b로만 이루어진 문자열 -> a만 모두 연속으로 만들기 위해 필요한 교환 횟수 최소


// 문자열 길이 최대 1000
// aabbaaabaa
// 15 8 a가 일자가 되는 모든 경우와 대조 비교해서
// 최소의 교환 횟수를 찾기기
// 1. a의 길이 구하기
// 2. 0번인덱스부터 n-1번 인덱스까지 a를 배치해가며 비교하기 (원형 배열열)
// aaaaaaaabbbbbbb
// baaaaaaaabbbbbb
// abbbbbbbaaaaaaa
class Main {
    
    static FastScanner fs = new FastScanner();
    
    public static void main(String[] args) throws Exception {
        String str = fs.next();
        int cnt = 0;
        int ret = 987654321;
        int n =str.length();
        for(int i = 0;i<n;i++){
            if(str.charAt(i) == 'a'){
                cnt++;
            }
        }
        for(int i = 0; i<n;i++){
            char [] arr = new char[n];
            int changeCnt = 0;
            for(int j= 0;j<n;j++){
                arr[j] = 'b';
            }
            for(int j = i; j< i+cnt;j++){
                arr[j%n] = 'a';
            }
            for(int j=0;j<n;j++){
                if(arr[j] != 'a' && arr[j] != str.charAt(j)){
                    changeCnt++;
                }
            }
            ret = Math.min(changeCnt,ret);
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
