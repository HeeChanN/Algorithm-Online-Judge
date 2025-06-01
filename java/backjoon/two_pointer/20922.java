import java.util.*;
import java.io.*;

// 같은 원소가 여러개 들어 있는 수열 싫어

// 같은 원소가 K개 이하로 들어있는 최장 연속 부분 수열의 길이

// N 의 길이-> 10만 이하의 양의 정수

// 큐에 담기
// -> 담을 때마다 visited 값 증가
// -> visited 값이 k보다 커질 때 큐의 길이와 ret의 값 비교후 visited 값이 감소할때까지 큐 제거
// 이후 큐에 넣고 다시 n-1까지 반복복


class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,k;
    static int ret = 1;
    static int [] arr = new int[200004];
    static int [] visited = new int [100004];
    static Queue<Integer> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        int p;
        Arrays.fill(visited,0);
        
        for(int i = 0;i<n;i++){
            p = arr[i];
            
            if(visited[p] <k){
                q.offer(p);
                visited[p]++;
            }
            else{
                ret = Math.max(ret, q.size());
                while(true){
                    int np = q.poll();
                    if(np == p){
                        q.offer(p);
                        break;
                    }
                    else{
                        visited[np]--;
                    }
                }
            }
        }
        ret = Math.max(ret, q.size());
        System.out.println(ret);
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
