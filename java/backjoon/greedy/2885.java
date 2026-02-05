import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine().trim());

        int S = 1;
        while (S < K) S <<= 1;

        // 2) 최소 쪼개기 횟수 구하기
        int split = 0;
        int cur = S;
        int remain = K;

        while (remain > 0) {
            if (remain >= cur) {
                remain -= cur;   
            } else {
                cur >>= 1;       
                split++;
            }
        }

        System.out.println(S + " " + split);
    }
}
