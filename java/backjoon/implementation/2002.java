import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        Queue<String> turnel = new ArrayDeque<>();
        //입장
        for(int i =0; i<n;i++){
            String carNumber = fs.next();
            turnel.offer(carNumber);
        }
        //퇴장
        Set<String> exitCars = new HashSet<>();
        int ret = 0;
        for(int i = 0; i<n;i++){
            String carNumber = fs.next();
            
            String front = turnel.peek();
            while(!turnel.isEmpty() && exitCars.contains(front)){
                turnel.poll();
                front = turnel.peek();
            }
            if(turnel.isEmpty()){
                break;
            }
            if(!front.equals(carNumber)){
                ret++;
            }
            else{
                turnel.poll();
            }
            exitCars.add(carNumber);
        }
        System.out.print(ret);
        
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception {
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
