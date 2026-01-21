import java.util.Scanner;

public class MarathonRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] checkpoints = new int[N][2];

        for (int i = 0; i < N; i++) {
            checkpoints[i][0] = sc.nextInt(); // x 좌표
            checkpoints[i][1] = sc.nextInt(); // y 좌표
        }

        int totalDistance = 0;
        for (int i = 0; i < N - 1; i++) {
            totalDistance += getDistance(checkpoints[i], checkpoints[i + 1]);
        }


        int maxReduction = 0;

        for (int i = 1; i < N - 1; i++) {

            int currentDist = getDistance(checkpoints[i - 1], checkpoints[i]) 
                            + getDistance(checkpoints[i], checkpoints[i + 1]);
            

            int skipDist = getDistance(checkpoints[i - 1], checkpoints[i + 1]);
            

            int reduction = currentDist - skipDist;
            maxReduction = Math.max(maxReduction, reduction);
        }


        System.out.println(totalDistance - maxReduction);
        
        sc.close();
    }

    public static int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
