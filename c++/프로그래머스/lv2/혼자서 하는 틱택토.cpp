#include <string>
#include <vector>

using namespace std;

int cnt1 = 0;
int cnt2 = 0;

pair<int,int> ans[8][3] = {
    {{0,0},{0,1},{0,2}},
    {{1,0},{1,1},{1,2}},
    {{2,0},{2,1},{2,2}},
    {{0,0},{1,0},{2,0}},
    {{0,1},{1,1},{2,1}},
    {{0,2},{1,2},{2,2}},
    {{0,0},{1,1},{2,2}},
    {{0,2},{1,1},{2,0}}
};

int solution(vector<string> board) {

    for(int i = 0; i<3;i++){
        for(int j = 0; j<3;j++){
            if(board[i][j] == 'O'){
                cnt1++;
            }
            else if(board[i][j] == 'X'){
                cnt2++;
            }
        }
    }
    if(cnt1 < cnt2){
        return 0;
    }
    if(cnt1 -1 > cnt2){
        return 0;
    }
    int flag1 = 0;
    int flag2 = 0;
    for(int i = 0; i<8;i++){
        if(board[ans[i][0].first][ans[i][0].second] == 'O' &&
           board[ans[i][1].first][ans[i][1].second] == 'O' &&
           board[ans[i][2].first][ans[i][2].second] == 'O'){
            flag1 = 1;
        }
        if(board[ans[i][0].first][ans[i][0].second] == 'X' &&
           board[ans[i][1].first][ans[i][1].second] == 'X' &&
           board[ans[i][2].first][ans[i][2].second] == 'X'){
            flag2 = 1;
        }
    }
    if(flag1 == 1 && flag2 == 1){
        return 0;
    }
    if(flag2 == 1 && cnt1 > cnt2){
        return 0;
    }
    if(flag1 == 1 && cnt2 == cnt1){
        return 0;
    }
    return 1;
}
