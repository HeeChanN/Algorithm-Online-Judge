import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int D, N, M;
    static int[] stones;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stones = new int[N + 1];
        for (int i = 0; i < N; i++) stones[i] = Integer.parseInt(br.readLine());
        Arrays.sort(stones, 0, N);
        stones[N] = D;

        int lo = 1, hi = D, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canKeepMinJump(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean canKeepMinJump(int minJump) {
        int prev = 0;
        int removed = 0;
        for (int i = 0; i < stones.length; i++) {
            int pos = stones[i];
            int gap = pos - prev;
            if (gap < minJump) {
                if (pos == D) return false;
                removed++;
                if (removed > M) return false;
            } else {
                prev = pos;
            }
        }
        return true;
    }
}
