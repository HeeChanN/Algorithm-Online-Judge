import java.util.*;

class Solution {

    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0,-1, 1,  0 };
    static char[] dir = { 'd','l','r','u' };

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || ((k - dist) % 2 == 1)) {
            return "impossible";
        }

        StringBuilder sb = new StringBuilder();
        int cx = x, cy = y;

        for (int step = 0; step < k; step++) {
            boolean moved = false;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 1 || nx > n || ny < 1 || ny > m){
                    continue;
                }

                int remain = k - step - 1;
                int need   = Math.abs(nx - r) + Math.abs(ny - c);

                if (need <= remain && ((remain - need) % 2) == 0) {
                    sb.append(dir[d]);
                    cx = nx; cy = ny;
                    moved = true;
                    break;
                }
            }
            if (!moved) 
                return "impossible";
        }
        return sb.toString();
    }
}
