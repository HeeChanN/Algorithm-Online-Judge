import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        // 2. 전체 넓이
        long totalArea = W * H;

        // 3. 겹치는 가로 길이 (접었을 때 2장이 되는 구간의 길이)
        // 왼쪽에서 f만큼 접으므로, f와 남은 오른쪽 길이(W-f) 중 짧은 쪽이 겹치는 구간임
        long overlapX = Math.min(f, W - f);

        // 4. 색칠된 영역의 가로, 세로 길이
        long paintW = x2 - x1;
        long paintH = y2 - y1;

        // 5. 2겹으로 겹친 부분에 색칠된 가로 길이 계산
        long doubleLayerWidth = 0;
        
        // x1이 겹치는 구간(overlapX)보다 왼쪽에 있다면 겹치는 부분이 존재함
        if (x1 < overlapX) {
            // x2와 overlapX 중 작은 값까지가 겹치는 구간의 끝
            doubleLayerWidth = Math.min(x2, overlapX) - x1;
        }

        // 6. 1겹 부분에 색칠된 가로 길이
        long singleLayerWidth = paintW - doubleLayerWidth;

        // 7. 총 지워지는 넓이 계산
        // 세로(c+1) * 세로길이 * (2겹구간*2 + 1겹구간*1)
        long removedArea = (c + 1) * paintH * (doubleLayerWidth * 2 + singleLayerWidth);

        // 8. 남은 넓이 출력
        System.out.println(totalArea - removedArea);
    }
}
