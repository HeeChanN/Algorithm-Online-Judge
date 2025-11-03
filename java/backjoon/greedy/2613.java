import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,m;
    static int [] arr = new int[304];
    static int [] s = new int[304];

    static Queue<Integer>[] q = new ArrayDeque[304];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<m+1;i++){
            q[i] = new ArrayDeque<>();
        }
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        int i;
        int tmp = 0;
        for(i = n-m; i>=0;i--){
            q[0].offer(arr[i]);
            tmp += arr[i];
        }
        s[0] = tmp;
        int groupIdx = 1;
        for(i = n-m +1;i<n;i++){
            q[groupIdx].offer(arr[i]);
            s[groupIdx] = arr[i];
            groupIdx++;
        }
        
        int ret = 987654321;
        int [] retArr = new int[m+1];
        // 가장 큰 값의 위치가 m-1일 때 까지 진행하기
        while(true){
            // for(i = 0; i<m;i++){
            //     System.out.print(s[i] + " ");
            // }
            // System.out.println();
            // for(i = 0; i<m;i++){
            //     System.out.print(q[i].size() + " ");
            // }
            // System.out.println();
            int maxVal = 0;
            int maxIdx = -1;
            for(i = 0; i< m;i++){
                if(s[i] > maxVal){
                    maxVal = s[i];
                    maxIdx = i;
                }
            }
            if(ret > maxVal){
                ret = maxVal;
                changeArr(retArr);
            }
            if(maxIdx == (m-1)){
                break;
            }
            // System.out.println(maxIdx);
            int transferNum = q[maxIdx].poll();
            q[maxIdx+1].offer(transferNum);
            s[maxIdx] -= transferNum;
            s[maxIdx+1] += transferNum;
        }
        sb.append(ret).append("\n");
        for(i = 0;i<m;i++){
            sb.append(retArr[i]).append(" ");
        }
        System.out.print(sb);
    }
    
    static void changeArr(int [] arr){
        for(int i = 0; i<m;i++){
            arr[i] = q[i].size();
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
