import java.util.*;
import java.io.*;

// 소문자 문자열 w, 양의 정수 k
// 어떤 문자를 정확히 k개 포함하는 가장 짧은 연속 문자열의 길이 구하기
// 어떤 문자를 정확히 k개 포함하고, 문자열의 첫번째와 마지막 글자가 해당 문자인 가장 긴 연속 문자열의 길이

// 게임 T회
// 문자열 w 길이 -> 1만 이하

// 방법은 2개로 보임
// 1. 투포인터
// 2. a~z까지 k개가 되는 시점에 left 옮기기

// -> 투포인터로 풀어보자. But 결국 a~z를 확인해야함 (4번 조건을 만족시키려면)

// left = 0;
// right를 움직여 가며 visited 증가
// visited가 K개 되는 시점에 left를 올려가며 K를 만든 알파벳의 위치로 이동시키기
// 해당 right - left를 구하고 가장 짧은지 파악 

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int t;
    static int [] visited = new int[30];
    static String s;
    static int k;
    static int minRet, maxRet;

    
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int i = 0; i<t;i++){
            s = fs.next();
            k = fs.nextInt();
            Arrays.fill(visited,0);
            minRet = 987654321;
            maxRet = 0;
            int left = 0;
            for(int j = 0;j<s.length();j++){
                char ch = s.charAt(j);
                visited[ch-'a']++;
                if(visited[ch-'a'] == k){
                    while(true){
                        char p = s.charAt(left);
                        if(p == ch){
                            int dist = j - left + 1;
                            minRet = Math.min(minRet, dist);
                            left++;
                            visited[p-'a']--;
                            break;
                        }
                        left++;
                        visited[p-'a']--;
                    }
                }
            }
            
            for(int j = 0;j< 26;j++){
                char compCh = (char)('a' + j);
                int cnt = 0;
                left = 0;
                for(int m = 0;m<s.length();m++){
                    if(s.charAt(m) == compCh){
                        cnt++;
                        if(cnt == k){
                            while(true){
                                if(s.charAt(left) == compCh){
                                
                                    int dist = m - left + 1;
                                    maxRet = Math.max(maxRet, dist);
                                    left++;
                                    cnt--;
                                    break;
                                }
                                left++;
                            }
                        }
                    }
                }
                
            }
            if(minRet == 987654321 && maxRet == 0){
                sb.append("-1\n");
            }
            else{
                sb.append(minRet).append(" ").append(maxRet).append("\n");
            }
        }
        System.out.println(sb);
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
