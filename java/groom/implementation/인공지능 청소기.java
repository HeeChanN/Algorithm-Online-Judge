import java.io.*;
import java.util.*;

		// 예약 청소 기능 -> 자유롭게 이동하다 사용자가 설정한 시간과 장소에 정확히 도착하는 기능/ 동일한 위치 두번이상 지나쳐서 청소할 수 있다.
		// 처음 위치 (0,0), 1초에 한번 움직임, 상하좌우 한반향
		// N초의 시간이 흐른 시점에 (X,Y)에 위치해야함
		// X, Y는 -10억부터 10억까지
		// N은 10억, N초 뒤에 청소기가 X,Y에 도착할 수 있다면 YES (0,0) -> (-5,-2)

// 1. 좌표까지 거리 계산
// 2. 거리가 같으면 가능
// 3. 거리가 크면 홀수일 경우 불가능
// 4. 거리가 작으면 불가능

class Main {

	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int t; // 테스트 케이스 수
	static int x,y,n;
	
	public static void main(String[] args) throws Exception {

		t = fs.nextInt();
		for(int i = 0; i<t;i++){
			x = fs.nextInt();
			y = fs.nextInt();
			n = fs.nextInt();
			logic();
			if(i != t-1){
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	static void logic(){ //(0,0) 과 (x,y) 도달 가능성 확인
		int dist = Math.abs(x-0) + Math.abs(y-0);
		if(dist == n){
			sb.append("YES");
		}
		else if(dist > n){
			sb.append("NO");
		}
		else if(dist < n){
			if((n - dist) % 2 == 1){
				sb.append("NO");
			} 
			else{
				sb.append("YES");
			}
		}
		
	}

	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception{
			while(st == null || !st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
	}
}
