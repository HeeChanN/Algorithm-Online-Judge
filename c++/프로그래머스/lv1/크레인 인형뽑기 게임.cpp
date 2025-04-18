#include <bits/stdc++.h>

using namespace std;

stack<int> bucket;
int arr[34];

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    
    memset(arr, -1 ,sizeof(arr));
    
    for(int i = 0; i<board.size();i++){
        for(int j = 0; j< board.size();j++){
            if(arr[j] == -1 && board[i][j] != 0){
                arr[j] = i;
            }
        }
    }
    bucket.push(0);
    
    for(int i = 0;i<moves.size();i++){
        int x = moves[i]-1;
        int y = arr[x];
        if (y == board.size()){
            continue;
        }
        if(bucket.top() == board[y][x]){
            answer = answer + 2;
            bucket.pop();
        }
        else{
            bucket.push(board[y][x]);
        }
        arr[x]++;
    }
    
    
    return answer;
}
