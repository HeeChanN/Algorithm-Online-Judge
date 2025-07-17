import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static String[] str = new String[54];
    static long [] score = new long[10];
    static int [] alphabet = new int[10];
    static int [] f = new int[10];
    
    static long ret = 0;
    
    static PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] a)->-a[0]));
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            str[i] = fs.next();
            f[str[i].charAt(0)-'A'] = 1; 
        }
        
        for(int i  =0 ;i<n;i++){
            long num = 1;
            for(int j = str[i].length()-1;j>=0;j--){
                score[str[i].charAt(j)-'A'] += num;
                num = num *10;
            }
        }
        // 제일 작으면서 f[idx]의 값이 0인 경우
        long m = Long.MAX_VALUE;
        int idx = 11;
        for(int i = 0; i<10;i++){
            if(m > score[i] && f[i] == 0){
                m = score[i];
                idx = i;
            }
            pq.offer(new long[]{score[i], i});
        }

        int num = 9;
        while(!pq.isEmpty()){
            long [] pos = pq.poll();
            if((int)pos[1] == idx){
                continue;
            }
            alphabet[(int)pos[1]] = num;
            num--;
        }
        
        for(int i = 0; i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<str[i].length();j++){
                sb.append(alphabet[str[i].charAt(j)-'A']);
            }
            ret += Long.parseLong(sb.toString());
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
