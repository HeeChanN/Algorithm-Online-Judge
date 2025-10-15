import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    public static void main(String[] args)  throws Exception{
        int [] arr = new int[54];
        int n = fs.nextInt();
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        if(n == 1){
            System.out.println("A");
        }
        else if (n == 2){
            if(arr[0] == arr[1]){
                System.out.print(arr[0]);
            }
            else{
                System.out.print("A");
            }
        }
        else{
            Set<Integer> s = new HashSet<>();
            for(int a = -200; a<=200;a++){
                int tmp = arr[0] * a;
                int b = arr[1] - tmp;
                int flag = 1;
                for(int i = 2;i<n;i++){
                    int num = arr[i] - b;
                    if(arr[i-1] * a != num){
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1){
                    s.add(arr[n-1] * a + b);
                }
            }
            if(s.size() == 0){
                System.out.print("B");
            }
            else if (s.size() == 1){
                for(int num : s){
                    System.out.print(num);
                }
            }
            else{
                System.out.print("A");
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
