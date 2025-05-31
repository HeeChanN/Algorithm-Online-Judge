import java.util.*;
import java.io.*;

// 풀이 순서

//1. 띄어쓰기 포함 입력 
//2. 단어 분리
//3. 단어 마다 첫 단어가 이미 등록되었는지 파악
//4. 왼쪽 단어의 첫 단어가 등록되어있으면 다음 단어의 첫단어 파악
//5. 다음 단어의 첫단어도 등록되어있으면 다시 처음 단어부터 등록 가능 여부 파악하기


class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    
    static String code;
    static Set<String> alphabet = new HashSet<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0;i<n;i++){
            int flag = -1;
            code = fs.nextLine();
            String [] arr = code.split(" ");
            for(int j = 0;j<arr.length;j++){
                String t = String.valueOf(arr[j].charAt(0));
                if(!alphabet.contains(t.toLowerCase())){
                    flag = j;
                    alphabet.add(t.toLowerCase());
                    break;
                }
            }
            if(flag != -1){
                for(int j = 0;j<arr.length;j++){
                    if(j == flag){
                        String t = String.valueOf(arr[j].charAt(0));
                        sb.append("[").append(t).append("]");
                        for(int k = 1;k<arr[j].length();k++){
                            String z = String.valueOf(arr[j].charAt(k));
                            sb.append(z);
                        }
                    }
                    else{
                        sb.append(arr[j]);
                    }
                    if(j != arr.length - 1){
                        sb.append(" ");
                    }
                }
            }
            else{
                int check = 0;
                for(int j = 0; j<code.length();j++){
                     String t = String.valueOf(code.charAt(j));
                     if(t.equals(" ")){
                         sb.append(t);
                         continue;
                     }
                     if(!alphabet.contains(t.toLowerCase()) && check == 0){
                         alphabet.add(t.toLowerCase());
                         sb.append("[").append(t).append("]");
                         check = 1;
                     }
                     else{
                         sb.append(t);
                     }
                }
            }
            if(i != n-1){
                sb.append("\n");
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
        
        String nextLine() throws Exception{
            return br.readLine();
        }
    }
}
