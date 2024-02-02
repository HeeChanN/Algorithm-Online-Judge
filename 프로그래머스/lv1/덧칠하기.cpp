#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    int i =1;
    int j = 0;
    while(i<=n && j < section.size()){
        if(section[j] < i){
            j++;
        }
        else if(i != section[j]){
            i++;
        }
        else if (i == section[j]){
            j++;
            i = i + m;
            answer++;
        }
    }
    return answer;
}
