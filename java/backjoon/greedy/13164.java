import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,m;
    static int [] arr = new int[300004];
    static int ret = 0;
    
    static PriorityQueue<int[]> diff = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).reversed());
    static PriorityQueue<Integer> idx = new PriorityQueue<>();
    
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        for(int i = 1; i<n;i++){
            int num = arr[i] - arr[i-1];
            diff.offer(new int[]{num,i});
        }
        
        while(!diff.isEmpty()){
            if(m == 1){
                break;
            }
            int [] pos = diff.poll();
            idx.offer(pos[1]);
            m--;
        }
        
        int j = 0;
        while(!idx.isEmpty()){
            int i = idx.poll();
            ret += arr[i-1] - arr[j];
            j = i;
        }
        ret += arr[n-1] - arr[j];
        System.out.print(ret);
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
