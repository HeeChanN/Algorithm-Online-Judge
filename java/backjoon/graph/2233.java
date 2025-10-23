import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    public static void main(String[] args) throws Exception{
        int n = fs.nextInt();
        int [] arr = new int[n * 2 + 1];
        int [] p = new int[n*2 + 1];
        String str = fs.next();
        int x = fs.nextInt() - 1;
        int y = fs.nextInt() - 1;
        
        int prevNode = 2 * n +1;
        int now = 0;
        for(int i = 0; i<str.length();i++){
            // System.out.println(parent + " " + now );
            if(str.charAt(i) == '0'){
                arr[i] = now;
                p[now] = prevNode;
                prevNode = now;
                now++;
            }
            if(str.charAt(i) == '1'){
                arr[i] = prevNode;
                prevNode = p[prevNode];
            }
        }
        
        ArrayList<Integer> xP = new ArrayList<>();
        ArrayList<Integer> yP = new ArrayList<>();
        
        xP.add(arr[x]);
        x = arr[x];
        while(p[x] != ( 2 * n +1)){
            xP.add(p[x]);
            x = p[x];
        }
        yP.add(arr[y]);
        y = arr[y];
        while(p[y] != ( 2 * n +1)){
            yP.add(p[y]);
            y = p[y];
        }
        
        int i = xP.size() - 1;
        int j = yP.size() - 1;
        int z = 2 * n + 1;
        while (i >= 0 && j >= 0 && xP.get(i).equals(yP.get(j))) {
            z = xP.get(i);
            i--;
            j--;
        }

        for (int pos = 0; pos < str.length(); pos++) {
            if (arr[pos] == z) {
                System.out.print((pos + 1) + " ");
            }
        }
    }
    
    static void print(int [] arr, int [] p){
        for(int i = 0; i<11; i++){
            System.out.println(arr[i]+" " + p[i]);
        }
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
