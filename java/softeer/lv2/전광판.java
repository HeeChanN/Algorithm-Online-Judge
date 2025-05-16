import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr = new ArrayList[11];
    
    public static void main(String[] args) throws Exception{
        init();
        int t = fs.nextInt();
        for(int i = 0; i<t;i++){
            String num1 = fs.next();
            String num2 = fs.next();
            String beforeNumber = plusZero(num1);
            String afterNumber = plusZero(num2);
            int total = 0;
            for(int j=0;j<5;j++){
                int a = beforeNumber.charAt(j) - '0';
                int b = afterNumber.charAt(j) - '0';
                if(a>=10){
                    a= 10;
                }
                if(b>=10){
                    b = 10;
                }
                total = total + calc(a,b);
            }
            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }

    static int calc(int a, int b){
        int[] visited = new int[8];
        int cnt = 0;
        for(Integer num : arr[b]){
            visited[num] = 1;
            cnt++;
        }
        for(Integer num : arr[a]){
            if(visited[num] == 1){
                cnt--;
            }
            else if (visited[num] == 0){
                cnt++;
            }
        }
        return cnt;
    }
    
    static String plusZero(String str){
        if(str.length() == 1){
            return "aaaa"+str;
        }
        else if(str.length() == 2){
            return "aaa"+str;
        }
        else if (str.length() == 3){
            return "aa"+str;
        }
        else if (str.length() == 4){
            return "a" + str;
        }
        else{
            return str;
        }
    }

    static void init(){
        for (int i = 0; i <= 10; i++) {
            arr[i] = new ArrayList<>();
        }
        arr[0].addAll(List.of(1,2,3,5,6,7));
        arr[1].addAll(List.of(3,6));
        arr[2].addAll(List.of(1,3,4,5,7));
        arr[3].addAll(List.of(1,3,4,6,7));
        arr[4].addAll(List.of(2,3,4,6));
        arr[5].addAll(List.of(1,2,4,6,7));
        arr[6].addAll(List.of(1,2,4,5,6,7));
        arr[7].addAll(List.of(1,2,3,6));
        arr[8].addAll(List.of(1,2,3,4,5,6,7));
        arr[9].addAll(List.of(1,2,3,4,6,7));
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
