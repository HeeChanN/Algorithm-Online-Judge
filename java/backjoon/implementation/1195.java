import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int [] arr;
    
    public static void main(String[] args) throws Exception{
        String str1 = fs.next();
        String str2 = fs.next();
        
        arr = new int[str1.length() + str2.length() * 2];
        
        int ret = arr.length;
        for(int i = 0; i<str1.length() + str2.length();i++){
            // 1. 시작전 중앙에 str1 배치하기
            Arrays.fill(arr,0);
            int idx = 0;
            for(int j = str2.length();j<str2.length() + str1.length();j++){
                arr[j] = str1.charAt(idx) - '0';
                idx++;
            }
            // 2. i부터 str2 숫자 입력
            int flag = 0;
            for(int j = i; j<i + str2.length();j++){
                int num = str2.charAt(j-i) - '0';
                if(num ==2 && 2 == arr[j]){
                    flag = 1;
                    break;
                }
                arr[j] += num;
            }
            //print();
            if(flag == 1){
                continue;
            }
            int left = Math.min(i,str2.length());
            int right = Math.max(str1.length()+str2.length(), i+str2.length());
            ret = Math.min(ret, right - left);
        }
        System.out.print(ret);
    }
    
    static void print(){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
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
    }
}
