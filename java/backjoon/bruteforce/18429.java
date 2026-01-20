import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] kits;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        kits = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            kits[i] = sc.nextInt();
        }

        backtracking(500, 0);

        System.out.println(count);
    }

    /**
     * @param weight 현재 중량
     * @param day    진행된 일수
     */
    static void backtracking(int weight, int day) {
        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (weight + kits[i] - K >= 500) {
                    visited[i] = true;
                    backtracking(weight + kits[i] - K, day + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
