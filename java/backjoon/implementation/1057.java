import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        
        int round = 1;
        
        while (true) {
 
            if ((jimin - 1) / 2 == (hansu - 1) / 2) {
                System.out.println(round);
                break;
            }
            
            jimin = (jimin + 1) / 2;
            hansu = (hansu + 1) / 2;
            round++;

            if (jimin == hansu) {
                System.out.println(-1);
                break;
            }
        }
    }
}
