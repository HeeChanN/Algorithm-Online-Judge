import java.util.*;
import java.io.*;

// 세로 2줄, 가로 N개

// y=1의 요소들 Set으로 add 하기
// 1<= N <= 100

// 0번 인덱스부터 n-1번 인덱스까지 순회하며 두 번째 row의 값을 이용하여 다음 첫번째 값을 뽑는 방식으로 진행

// 시작지점을 2번 방문하는게 아니면 뽑지 않기 

// 이미 포함시킨 idx들의 경우 alreadyPick에 반영하기

// visited는 초기화화

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int[][] arr = new int[2][104];
    static int[] visited = new int[104];
    static int[] alreadyPick = new int[104];
    static int n;
    static int ret = 0;
    static ArrayList<Integer> numbers = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i  =1;i<=n;i++){
            arr[0][i] = i;
            arr[1][i] = fs.nextInt();
        }
        
        for(int i  = 1;i<=n;i++){
            Arrays.fill(visited, 0);
            if(alreadyPick[i] != 1 && travel(i)){
                for(int j  =1;j<=n;j++){
                    if(visited[j] != 0){
                        alreadyPick[j] = 1;
                    }
                }
            }
        }
        for(int i =1;i<=n;i++){
            if(alreadyPick[i] == 1){
                ret++;
                numbers.add(i);
            }
        }
        System.out.println(ret);
        for(Integer a : numbers){
            System.out.println(a);
        }
    }
    
    static boolean travel(int idx){
        boolean t = false;
        Queue<Integer> q = new ArrayDeque<>();
        visited[idx] = 1;
        q.offer(idx);
        
        while(!q.isEmpty()){
            int i = q.poll();
            int next = arr[1][i];
            visited[next]++;
            if(visited[next] == 2){
                if(next == idx){
                    t = true;
                }
                break;
            }
            q.offer(next);
        }
        return t;
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
