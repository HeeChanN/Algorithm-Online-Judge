import java.io.*;
import java.util.*;

// 1~N번 순서대로 집이 있음, 땅 높이 각각 다름 i번째 집의 땅 높이 ki, 땅 높이의 기준 -> 해수면 따라서 해수면 보다 낮은 위치에 집이 있다면 높이가 음수일 수 있음
// 장마 -> M일동안 비 옴
// i일 째 si 번 집이 있는 위치부터 ei번 집이 있는 위치까지 비가 내림
// 비가 내리면 집에 쌓인 물의 높이 1 증가
// 배수 시스템 -> 장마가 시작된지 3의 배수가 되는 날마다 비가 내리고 동작
// 작동 날짜 기준 2일 이내에 비가 내린 위치에서만 동작 -> 9일째에 작동하는 시스템은 7,8,9일 째에 비가 내린 위치에서만 작동
// 배수 시스템이 작동하면 물의 높이 1만큼 감소
// 장마가 지나간 뒤 모든 땅 높이는 그 땅에 쌓였던 물의 높이만큼 증가


// 1. s ~ e 에 비가온다. => 배열에 +1 해주기
// 2. 배수 시스템 동작 (3의 배수) q의 날짜 꺼내서 -1해주고 다시넣기 (2번만 수행) + 오늘 날짜 -1
// 3. q에 오늘 s~e -> q 사이즈 2 미만일 때는 넣고 2일 때는 넣고 삭제
// 4. 반복

class Main {

	static FastScanner fs = new FastScanner();
	static int n,m; //n = 집의 개수, m = 장마기간
	static int [] house = new int[1004];
	static Queue<int[]> q = new ArrayDeque<>();
	static int s,e;
	
	public static void main(String[] args) throws Exception {
		n = fs.nextInt();
		m = fs.nextInt();

		for(int i = 1; i<=n;i++){
			house[i] = fs.nextInt();
		}
		for(int i = 1;i<=m;i++){
			s = fs.nextInt();
			e = fs.nextInt();
			rain();
			if(i%3 == 0){
				removeWater();
			}
			if(q.size() <=2){
				if(q.size() == 2){
					q.poll();
				}
				q.offer(new int[]{s,e});
			}
		}
		for(int i = 1;i<=n;i++){
			System.out.print(house[i]+" ");
		}
	}

	static void rain(){
		for(int i =s;i<=e;i++){
			house[i]++;
		}
	}

	//비가 내린 위치 기록
	static void removeWater(){
		int [] visited = new int[1004];
		int minS = s;
		int mE = e;
		for(int i = s; i<=e;i++){
			visited[i] = 1;
		}
		for(int i = 0;i<2;i++){
			int [] p = q.poll();
			int ps = p[0];
			int pe = p[1];
			for(int j = ps; j<=pe;j++){
				visited[j] = 1;
			}
		}
		for(int i = 1;i<=n;i++){
			if(visited[i] == 1){
				house[i]--;
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
