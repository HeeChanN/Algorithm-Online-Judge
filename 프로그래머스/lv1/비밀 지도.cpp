#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i = 0; i< arr1.size();i++){
        string str ="";
        for(int j = n-1;j>=0;j--){
            int tmp = arr1[i] | arr2[i];
            if(tmp & (1<<j))
                str = str+ '#';
            else
                str = str + ' ';
        }
        answer.push_back(str);
    }
    
    
    return answer;
}
