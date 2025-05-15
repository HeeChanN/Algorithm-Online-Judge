import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int total = 0;
        
        for(int i = 0; i<5;i++){
            String startTime = fs.next();
            String endTime = fs.next();
            total = total + changeTime(endTime) - changeTime(startTime);
        }
        System.out.print(total);
    }

    static int changeTime(String time){
        String[] hm = time.split(":");
        int hour = Integer.parseInt(hm[0]) * 60;
        int minute = Integer.parseInt(hm[1]);
        return hour + minute;
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
    }
}
