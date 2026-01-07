import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        char[][] g = new char[N + 1][N + 1]; // 1-indexed
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            // 혹시 공백이 섞여 들어오는 변형 입력 대비
            line = line.replace(" ", "").trim();
            for (int j = 1; j <= N; j++) {
                g[i][j] = line.charAt(j - 1);
            }
        }

        int headR = -1, headC = -1;
        outer:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (g[i][j] == '*') {
                    headR = i;
                    headC = j;
                    break outer;
                }
            }
        }

        int heartR = headR + 1;
        int heartC = headC;

        int leftArm = 0;
        for (int c = heartC - 1; c >= 1 && g[heartR][c] == '*'; c--) leftArm++;

        int rightArm = 0;
        for (int c = heartC + 1; c <= N && g[heartR][c] == '*'; c++) rightArm++;

        int waist = 0;
        int r = heartR + 1;
        while (r <= N && g[r][heartC] == '*') {
            waist++;
            r++;
        }
        int waistEndR = heartR + waist;

        int leftLeg = 0;
        r = waistEndR + 1;
        int leftLegC = heartC - 1;
        while (r <= N && g[r][leftLegC] == '*') {
            leftLeg++;
            r++;
        }

        int rightLeg = 0;
        r = waistEndR + 1;
        int rightLegC = heartC + 1;
        while (r <= N && g[r][rightLegC] == '*') {
            rightLeg++;
            r++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heartR).append(' ').append(heartC).append('\n');
        sb.append(leftArm).append(' ')
          .append(rightArm).append(' ')
          .append(waist).append(' ')
          .append(leftLeg).append(' ')
          .append(rightLeg).append('\n');

        System.out.print(sb.toString());
    }
}
