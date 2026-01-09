import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] positions = new int[M];
        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        
        int height = 0;
        
        // 1. 시작점(0) 커버 체크
        height = Math.max(height, positions[0]);
        
        // 2. 끝점(N) 커버 체크
        height = Math.max(height, N - positions[M - 1]);
        
        // 3. 가로등 사이 간격 체크
        for (int i = 0; i < M - 1; i++) {
            int gap = positions[i + 1] - positions[i];
            // 양쪽에서 비추므로 gap/2만큼 필요 (올림 처리)
            int requiredHeight = (gap + 1) / 2;
            height = Math.max(height, requiredHeight);
        }
        
        System.out.println(height);
    }
}
