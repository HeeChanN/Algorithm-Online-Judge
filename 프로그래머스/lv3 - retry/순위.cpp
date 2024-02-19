#include <string>
#include <vector>

using namespace std;

int arr[102][102];

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    
    for(int i = 0;i<results.size();i++){
        arr[results[i][0]][results[i][1]] = 1;
        arr[results[i][1]][results[i][0]] = 2;
    }
    
    for(int k = 1; k <= n;k++){
        for(int i = 1; i <= n;i++){
            for(int j = 1; j <= n;j++){
                if(arr[i][k] == 1 && arr[k][j] == 1){
                    arr[i][j] = 1;
                    arr[j][i] = 2;
                }
            }
        }
    }
    
    for(int i = 1; i<=n;i++){
        int cnt = 0;
        for(int j = 1;j<=n;j++){
            if(arr[i][j] != 0){
                cnt++;
            }
        }
        if(cnt == n-1){
            answer++;
        }
    }
    
    return answer;
}
