import java.util.*;
import java.io.*;

// 3x3 격자판
// 첫번째 사람 x, 두번째 사람 o

// 게임판이 주어지면 틱택토 게임에서 발생할 수 있는 최종 상태인지 판별하기

// 1. 입력 받기
// 2. x부터 시작이므로 x의 개수가 o보다 많거나 같아야함. 그렇다고 x의 개수가 o보다 2이상 많으면 안됨

// 둘다 3칸이 이어지면 안됨
// 즉, 최종 상태는 x 또는 o 둘중 하나가 이기거나 무승부

// oxo
// xx.
// ..o

// xxx
// oo.
// ..o

// 0,1,2 / 3,4,5 / 6,7,8 / 0,3,6 / 1,4,7 / 2,5,8 / 0,4,8 / 2,4,6/ 

// 1. x,o 개수 세기 -> 개수 올바르지 않으면 바로 invalid
// 2. 우승자 파악 둘다 우승자면 안됨, 무승부는 가능

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static String board;
    static int[][] check = {
        {0,1,2},{3,4,5},{6,7,8},
        {0,3,6},{1,4,7},{2,5,8},
        {0,4,8},{2,4,6}
    };
    static int t = 1;
    static int xCnt;
    static int oCnt;
    
    public static void main(String[] args) throws Exception{
        
        while(true){
            board = fs.next();
            if(board.equals("end")){
                break;
            }
            if(validateCnt()){
                validateWin();
            }
            else{
                sb.append("invalid\n");
            }
            t++;
        }
        System.out.print(sb);
    }
    // XXO
    // OOX
    // XOX
    static void validateWin(){
        int xWin = 0;
        int oWin = 0;
        for(int i  =0;i<8;i++){
            int [] p = check[i];
            char ch1 = board.charAt(p[0]);
            char ch2 = board.charAt(p[1]);
            char ch3 = board.charAt(p[2]);
            if(ch1 == ch2 && ch2 == ch3){
                if(ch1 == 'X'){
                    xWin++;
                }
                else if(ch1 == 'O'){
                    oWin++;
                }
            }
        }
        if(xWin > 0 && oWin > 0){
            sb.append("invalid\n");
        }
        else if(xCnt>oCnt && oWin > 0){
            sb.append("invalid\n");
        }
        else if (xWin>0 && xCnt == oCnt){
            sb.append("invalid\n");
        }
        else if (xWin ==0 && oWin == 0){
           if((xCnt + oCnt) != 9){
               sb.append("invalid\n");
           }
           else{
               sb.append("valid\n");
           }
        }
        else{
            sb.append("valid\n");
        }
    }
    
    static boolean validateCnt(){
        xCnt = 0;
        oCnt = 0;
        for(int i =0;i<board.length();i++){
            if(board.charAt(i) == 'X'){
                xCnt++;
            }
            else if (board.charAt(i) == 'O'){
                oCnt++;
            }
        }
        if(xCnt >= oCnt && ((xCnt - oCnt) <2)){
            return true;
        }
        else{
            return false;
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
