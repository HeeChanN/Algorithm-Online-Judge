import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int [][] square = {
        {0,2,0,2},{0,2,3,5},{0,2,6,8},
        {3,5,0,2},{3,5,3,5},{3,5,6,8},
        {6,8,0,2},{6,8,3,5},{6,8,6,8},
    };
    
    static int [][] board = new int[9][9];
    static ArrayList<int[]> arr = new ArrayList<>();
    static int flag = 0;
    
    public static void main(String[] args) throws Exception{
        
        for(int i = 0;i<9;i++){
            for(int j = 0; j<9;j++){
                board[i][j] = fs.nextInt();
                if(board[i][j] == 0){
                    for(int k = 0; k<9;k++){
                        if(i >= square[k][0] && i <= square[k][1] && j>=square[k][2] && j<=square[k][3]){
                            arr.add(new int[]{i,j,k});
                            break;
                        }
                    }
                }
            }
        }
        go(0);
        System.out.print(sb);
    }
    
    static void go(int idx){
        if(idx == arr.size()){
            flag = 1;
            fillAnswer();
            return;
        }
        int [] p = arr.get(idx);
        for(int i = 1; i<=9;i++){
            if(!isValid(p,i)){
                continue;
            }
            board[p[0]][p[1]] = i;
            go(idx+1);
            board[p[0]][p[1]] = 0;
            if(flag == 1){
                return;
            }
        }
    }
    
    static boolean isValid(int [] p,int num){
        int y = p[0];
        int x = p[1];
        int s = p[2];
        
        // 가로 확인
        for(int i = 0;i<9;i++){
            if(board[y][i] == num){
                return false;
            }
        }
        
        //세로 확인
        for(int i = 0;i<9;i++){
            if(board[i][x] == num){
                return false;
            }
        }
        
        // 정사각형 확인
        for(int i = square[s][0]; i<= square[s][1];i++){
            for(int j = square[s][2]; j<= square[s][3];j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
    
        return true;
    }
    
    static void fillAnswer(){
        for(int i = 0; i<9;i++){
            for(int j = 0;j<9;j++){
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
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
