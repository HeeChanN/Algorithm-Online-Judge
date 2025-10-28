import java.util.*;

class Solution {
    
    static int [][] arr;
    static int [][] check;
    
    static int N,M;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = n;
        M = m;
        arr = new int[m][n];
        check = new int[m][n];
        for(int i =0 ; i<board.length;i++){
            for(int j = 0;j<board[i].length();j++){
                arr[i][j] = board[i].charAt(j) - 'A'+ 1;
            }
        }
        while(true){
            checkBlockToErase();
            int count = eraseAndCount();
            if(count == 0){
                break;
            }
            moveBlock();
            answer += count;
            for(int [] row : check){
                Arrays.fill(row, 0);
            }
        }
        
        return answer;
    }
    
    static void checkBlockToErase(){
        for(int i = 0; i<M-1;i++){
            for(int j = 0; j<N-1;j++){
                int cur = arr[i][j];
                if(cur == 0){
                    continue;
                }
                if(cur == arr[i+1][j] && cur == arr[i][j+1] && cur == arr[i+1][j+1]){
                    check[i][j] = 1;
                    check[i][j+1] = 1;
                    check[i+1][j] = 1;
                    check[i+1][j+1] = 1;
                }
            }
        }
    }
    
    static int eraseAndCount(){
        int count = 0;
        for(int i = 0; i<M;i++){
            for(int j = 0; j<N;j++){
                if(check[i][j] == 1){
                    arr[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }
    
    static void moveBlock(){
        for(int i = N-1; i>=0;i--){
            Queue<int[]> q = new ArrayDeque<>();
            for(int j = M -1; j>=0;j--){
                if(arr[j][i] == 0){
                    q.offer(new int[]{j,i});
                }
                else{
                    if(!q.isEmpty()){
                        int [] cur = q.poll();
                        int tmp = arr[cur[0]][cur[1]];
                        arr[cur[0]][cur[1]] = arr[j][i];
                        arr[j][i] = tmp;
                        q.offer(new int[]{j,i});
                    }
                }
            }
        }
    }
    
    static void print(){
        for(int i = 0; i<M;i++){
            for(int j = 0; j<N;j++){
                System.out.print(arr[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
}
