import java.util.*;
import java.io.*;

// N x N 복도
// 선생님, 학생, 장애물
// 선생님의 감시에 들키지 않는 것이 목표
// 선생님 -> 상하좌우 4방향 감시
// 장애물이 있을 때는 장애물 뒤편은 볼 수 없다.
// T : 선생님, S : 학생, O : 장애물

// 정확히 3개의 장애물 설치
// -> 모든 학생들을 감시로부터 피하도록 할 수 있는지 계산하기기

// 자연수 N (3 <= N <= 6)

// 1. 빈 공간 3곳 뽑기 (조합)
// 2. 해당 위치 O로 막고 선생님 감시 영역 살펴보았을 때 S가 있으면 다음 3곳 뽑기
// 3. 모든 경우를 보았을 때 1곳이라도 있다면 answer = YES


// 선생님 위치 담는 배열
// 빈 공간 위치 담는 배열열

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static char [][] board = new char[8][8];
    static int n;
    
    
    static ArrayList<int[]> t = new ArrayList<>();
    static ArrayList<int[]> blank = new ArrayList<>();
    
    static ArrayList<Integer> pick = new ArrayList<>();
    
    static String ret = "NO";
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i  =0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.next().charAt(0);
                if(board[i][j] == 'T'){
                    t.add(new int[]{i,j});
                }
                if(board[i][j] == 'X'){
                    blank.add(new int[]{i,j});
                }
            }
        }
        
        comb(-1);
        System.out.print(ret);
    }
    
    static void comb(int start){
        if(pick.size() == 3){
            logic();
            return ;
        }
        for(int i = start+1;i<blank.size();i++){
            pick.add(i);
            comb(i);
            pick.remove(pick.size()-1);
        }
    } 
    
    static void logic(){
        
        for(int idx  : pick){
            int[] p = blank.get(idx);
            int py = p[0];
            int px = p[1];
            board[py][px] = 'O';
        }
      
        int cnt = 0;
        for(int [] p : t){
            int py = p[0];
            int px = p[1];
            for(int i = 0; i<4;i++){
                cnt += dirSearch(i,py,px);
            }
        }
        
        if(cnt == 0){
            ret = "YES";
        }
    
        for(int idx  : pick){
            int[] p = blank.get(idx);
            int py = p[0];
            int px = p[1];
            board[py][px] = 'X';
        }
    }
    
    static int dirSearch(int dir,int y,int x){
        int cnt = 0;
        int ny = y;
        int nx= x;
        while(true){
            ny = ny + dy[dir];
            nx = nx + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 'O'){
                break;
            }
            if(board[ny][nx] == 'S'){
                cnt++;
                break;
            }
        }
        return cnt;
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j  =0;j<n;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st ==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
