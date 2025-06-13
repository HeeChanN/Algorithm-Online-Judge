import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,t;
    static String tmp;
    
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int i = 0; i<t;i++){
            boolean ret = true;
            n = fs.nextInt();
            ArrayList<String> phones = new ArrayList<>();
            for(int j = 0; j<n;j++){
                tmp = fs.next();
                phones.add(tmp);
            }
            phones.sort(Comparator.naturalOrder());
            
            for(int j = 1;j<phones.size();j++){
                String a = phones.get(j);
                String b = phones.get(j-1);
                
                int len = Math.min(a.length(), b.length());
                int cnt = 0;
                for(int k = 0; k<len;k++){
                    if(a.charAt(k) == b.charAt(k)){
                        cnt++;
                    }
                }
                if(cnt == len){
                    ret = false;
                    break;
                }
            }
            if(ret){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
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
