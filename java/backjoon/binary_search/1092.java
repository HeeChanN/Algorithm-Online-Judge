import java.util.*;
import java.io.*;

class Main {
    
    static int n,m,tmp;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> items = new ArrayList<>();

    
    static FastScanner fs = new FastScanner();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            tmp = fs.nextInt();
            arr.add(tmp);
        }
        arr.sort(Comparator.comparingInt((Integer a) -> -a));
        
        m = fs.nextInt();
        for(int i = 0; i<m;i++){
            tmp = fs.nextInt();
            items.add(tmp);
        }
        
        items.sort(Comparator.comparingInt((Integer a) -> -a));
        int ret = 987654321;
        int cnt = 0;
        if(items.get(0) > arr.get(0)){
            ret = -1;
        }
        else{
            int l = 1;
            int r = m;
            while(l<=r){
                int mid = l + (r-l)/2;
                int j = mid - 1;
                int prev = -1;
                int flag = 0;
                for(int i = 0; i<n;i++){
                    int limit = arr.get(i);
                    int num = items.get(Math.min(m-1,j));
                    if(limit < num  || items.get(Math.min(m-1,prev+1)) > limit){
                        break;
                    }
                    prev = j;
                    j = j + mid;
                }
                j = j - mid;
                if(j < m-1){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                    ret = Math.min(ret,mid);
                }
            }
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
