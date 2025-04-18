#include <string>
#include <vector>

using namespace std;

vector<int> v;
vector<int> v2;

int solution(int storey) {
    int answer = 0;
    
    int ret1 = 0;
    int ret2 = 0;
    while(storey != 0){
        int num = storey % 10;
        storey = storey / 10;
        v.push_back(num);
        v2.push_back(num);
    }

    for(int i = 0; i< v.size()-1;i++){
        
        if(v[i] <= 5){
            ret1 += v[i];
        }
        else{
            ret1 = ret1 + 10 - v[i];
            v[i+1] = v[i+1] +1;
        }
        if(v2[i]< 5){
            ret2 += v[i];
        }
        else{
            ret2 = ret2 + 10 - v2[i];
            v2[i+1] = v2[i+1] + 1;
        }
    }
    if(v[v.size()-1] <=5){
        ret1 = ret1 + v[v.size()-1];
    }
    else{
        ret1 = ret1 + 10 - v[v.size()-1] + 1;
    }
    if(v2[v2.size()-1] <=5){
        ret2 = ret2 + v2[v2.size()-1];
    }
    else{
        ret2 = ret2 + 10 - v2[v2.size()-1] + 1;
    }
    answer = min(ret1,ret2);
    return answer;
}
