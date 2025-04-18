#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    
    for(int i = 1; i<=t;i++){
        int k;
        string str;
        vector<string> trie;
        
        cin >> k;
        cin >> str;
        for(int i = 0; i<str.length(); i++){
            for(int j = 1; j<=str.length()-i;j++){
                trie.push_back(str.substr(i,j));
            }
        }
        sort(trie.begin(), trie.end());
        trie.erase(unique(trie.begin(),trie.end()), trie.end());
        
        if(trie.size() < k){
            cout<<"#" << i << " " << "none" << "\n";
        }
        else{
            cout<<"#" << i << " " << trie[k-1] << "\n";
        }
        
        
    }
}
