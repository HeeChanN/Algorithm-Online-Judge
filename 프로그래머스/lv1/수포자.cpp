#include <string>
#include <vector>

using namespace std;

int supo1[] = { 1,2,3,4,5 };
int supo2[] = { 2,1,2,3,2,4,2,5 };
int supo3[] = { 3,3,1,1,2,2,4,4,5,5 };

int ret;
int s;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    s = answers.size();

    int cnt = 0;
    for (int i = 0; i < s; i++) {
        if (supo1[i % 5] == answers[i]) {
            cnt++;
        }
    }
    if (ret <= cnt) {
        answer.push_back(1);
        ret = cnt;
    }

    cnt = 0;
    for (int i = 0; i < s; i++) {
        if (supo2[i % 8] == answers[i]) {
            cnt++;
        }
    }
    if (ret <= cnt) {
        if (ret != cnt) {
            answer.pop_back();
        }
        answer.push_back(2);
        ret = cnt;
    }

    cnt = 0;
    for (int i = 0; i < s; i++) {
        if (supo3[i % 10] == answers[i]) {
            cnt++;
        }
    }
    if (ret <= cnt) {
        if (ret != cnt) {
            answer.pop_back();
        }
        answer.push_back(3);
        ret = cnt;
    }

    return answer;
}