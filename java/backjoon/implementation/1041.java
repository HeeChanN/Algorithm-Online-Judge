import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();  
    static long n;
    // A B C D E F
    static long [] arr = new long[6];
    static long ret = 0;
    static long minThree = Long.MAX_VALUE;
    static long minTwo = Long.MAX_VALUE;
    static long minOne = Long.MAX_VALUE;
    
    public static void main(String[] args) throws Exception{
        n  = fs.nextLong();
        
        for(int i = 0; i<6;i++){
            arr[i] = fs.nextLong();
            minOne = Math.min(minOne, arr[i]);
        }
        calcMinTwo();
        calcMinThree();
       // System.out.println(minOne + " " + minTwo + " " + minThree);
        if(n==1){
            Arrays.sort(arr);
            for(int i = 0; i<5;i++){
                ret = ret + arr[i];
            }
        }
        else{
            // 1. 맨 위 구하기  N 층
            ret += 4 * minThree;
            ret += (n-2) * 4 * minTwo;
            ret += (n-2) * (n-2) * minOne;
            //System.out.println(ret);
            // 2. 나머지 구하기 1 ~ N-1층
            // 층 * ( 모서리 4개 + 모서리 제외 면)
            ret += (4 * minTwo) * (n-1);
            ret += (4 * minOne * (n-2)) * (n-1);
        }
        System.out.print(ret);
    }

    static void calcMinTwo(){
        minTwo = Math.min(minTwo, arr[0] + arr[3]);
        minTwo = Math.min(minTwo, arr[0] + arr[1]);
        minTwo = Math.min(minTwo, arr[0] + arr[2]);
        minTwo = Math.min(minTwo, arr[0] + arr[4]);
        
        minTwo = Math.min(minTwo, arr[5] + arr[3]);
        minTwo = Math.min(minTwo, arr[5] + arr[1]);
        minTwo = Math.min(minTwo, arr[5] + arr[2]);
        minTwo = Math.min(minTwo, arr[5] + arr[4]);
        
        minTwo = Math.min(minTwo, arr[2] + arr[4]);
        minTwo = Math.min(minTwo, arr[1] + arr[3]);
        minTwo = Math.min(minTwo, arr[3] + arr[4]);
        minTwo = Math.min(minTwo, arr[1] + arr[2]);
    }

    // 0 1 2 3 4 5
    // A B C D E F    
    static void calcMinThree(){
        minThree = Math.min(minThree, arr[0] + arr[1] + arr[2]);
        minThree = Math.min(minThree, arr[0] + arr[1] + arr[3]);
        minThree = Math.min(minThree, arr[0] + arr[3] + arr[4]);
        minThree = Math.min(minThree, arr[0] + arr[2] + arr[4]);
        minThree = Math.min(minThree, arr[5] + arr[1] + arr[2]);
        minThree = Math.min(minThree, arr[5] + arr[1] + arr[3]);
        minThree = Math.min(minThree, arr[5] + arr[3] + arr[4]);
        minThree = Math.min(minThree, arr[5] + arr[2] + arr[4]);
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
