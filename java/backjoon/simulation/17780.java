// https://www.acmicpc.net/problem/17780

import java.util.*;
import java.io.*;

class Main {

    static int [] dy = {0,0,0,-1,1};
    static int [] dx = {0,1,-1,0,0};

    static FastScanner fs = new FastScanner();
    static Queue<int[]>[][] board = new ArrayDeque[13][13];
    static int[][] arr = new int[13][13];
    static int n,k;
    static int a,b,c;
    static int[][] players = new int[11][2];
    static int ret = -1;

    public static void main(String[] args)throws Exception {
        n = fs.nextInt();
        k = fs.nextInt();

        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                arr[i][j] = fs.nextInt();
                board[i][j] = new ArrayDeque<>();
            }
        }
        for(int i = 0; i<k;i++){
            a = fs.nextInt();
            b = fs.nextInt();
            c = fs.nextInt();
            board[a-1][b-1].offer(new int[]{i,c});
            players[i][0] = a-1;
            players[i][1] = b-1;
        }

        int t = 0;
        while(true){
            if(t >= 1000){
                ret = -1;
                break;
            }

            boolean finished = false;
            for(int i = 0; i<k;i++){
                int py = players[i][0];
                int px = players[i][1];

                if(board[py][px].peek()[0] != i) {
                    continue;
                }

                Queue<int[]> move = new ArrayDeque<>();
                while(!board[py][px].isEmpty()){
                    move.offer(board[py][px].poll());
                }

                int[] first = move.poll(); 
                int dir = first[1];
                int ny = py + dy[dir];
                int nx = px + dx[dir];

                //파랑 or 경계일 경우
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || arr[ny][nx] == 2){
                    dir = changeDir(dir);
                    first[1] = dir; 
                    ny = py + dy[dir];
                    nx = px + dx[dir];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || arr[ny][nx] == 2){
                        board[py][px].offer(first);
                        while(!move.isEmpty()){
                            board[py][px].offer(move.poll());
                        }
                        continue;
                    }
                }
                
                // 빨강일 경우
                if(arr[ny][nx] == 1){
                    Deque<int[]> s = new ArrayDeque<>();
                    s.push(first);
                    while(!move.isEmpty()){
                        s.push(move.poll());
                    }
                    while(!s.isEmpty()){
                        int [] tmp = s.pop();
                        players[tmp[0]][0] = ny;
                        players[tmp[0]][1] = nx;
                        board[ny][nx].offer(tmp);
                    }
                }
                
                // 흰색일 경우우
                else{
                    board[ny][nx].offer(first);
                    players[first[0]][0] = ny;
                    players[first[0]][1] = nx;
                    while(!move.isEmpty()){
                        int [] tmp = move.poll();
                        players[tmp[0]][0] = ny;
                        players[tmp[0]][1] = nx;
                        board[ny][nx].offer(tmp);
                    }
                }

                if(isFinished()){
                    finished = true;
                    break;
                }
            }

            t++;
            if(finished){
                ret = t;
                break;
            }
        }
        System.out.print(ret);
    }

    static boolean isFinished(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j].size() >= 4){
                    return true;
                }
            }
        }
        return false;
    }

    static int changeDir(int i){
        if(i ==1) return 2;
        else if (i == 2) return 1;
        else if (i == 3) return 4;
        else return 3;
    }

    static class FastScanner {
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
