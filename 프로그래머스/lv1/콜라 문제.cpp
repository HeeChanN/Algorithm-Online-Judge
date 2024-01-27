#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    int num = n;
    int c = 0;
    int cnt= 0;
    
    while(num >= a){
        c = num % a;
        num = num / a;
        cnt += num * b;
        num = num * b + c;
    }
    answer = cnt;
    
    return answer;
}
