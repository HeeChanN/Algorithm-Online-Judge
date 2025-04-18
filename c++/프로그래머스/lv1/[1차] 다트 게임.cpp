#include <string>

using namespace std;

int arr[4];

int solution(string dartResult) {
    int answer = 0;
    int idx = 0;
    int num = 0;
    int cnt = 0;
    while(idx < dartResult.length()){
        if('0' <= dartResult[idx] && dartResult[idx] <='9'){
            arr[cnt] = num;
            cnt++;
            if(dartResult[idx] == '1' && dartResult[idx+1]=='0'){
                num = 10;
                idx++;
            }
            else
                num = dartResult[idx] - '0';
        }
        else if(dartResult[idx] == 'D'){
            num = num * num;
        }
        else if(dartResult[idx] == 'T'){
            num = num * num * num;
        }
        else if(dartResult[idx] == '*'){
            arr[cnt-1] = arr[cnt-1] *2;
            num = num * 2;
        }
        else if (dartResult[idx] == '#'){
            num = -num;
        }
        idx++;
    }
    arr[3] = num;
    for(int i = 1;i<=3;i++){
        answer += arr[i];
    }
    return answer;
}
