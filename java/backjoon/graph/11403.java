import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] reach = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                reach[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Floyd-Warshall for transitive closure
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (reach[i][k] == 0) continue;
                for (int j = 0; j < N; j++) {
                    if (reach[k][j] == 1) reach[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(reach[i][j]);
                if (j + 1 < N) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
