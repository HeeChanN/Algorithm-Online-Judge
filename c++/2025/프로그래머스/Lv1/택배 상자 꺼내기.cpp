#include<bits/stdc++.h>

using namespace std;

int arr[100][100];
int i = 0;
int k = 1;
pair<int,int> pos;

int solution(int n, int w, int num) {
    int answer = 0;
    
    while(k<=n){
        if(i%2==0){//왼 -> 오
            for(int j = 0;j<w;j++){
                arr[i][j] = k;
                if(k == num){
                    pos = {i,j};
                }
                k++;
                if(k>n){
                    break;
                }
            }
        }
        else{// 오 -> 왼
            for(int j = w-1;j>=0;j--){
                arr[i][j] = k;
                if(k == num){
                    pos = {i,j};
                }
                k++;
                if(k>n){
                    break;
                }
            }
        }
        i++;
    }
    int y = pos.first;
    answer = 1;
    while(true){
        y = y+1;
        if(arr[y][pos.second] == 0){
            break;
        }
        answer++;
    }
    
    
    
    return answer;
}
