#include <vector>
#include <unordered_map>
#include <iostream>
#include <string>
#include <cstddef>
#include <climits>

using namespace std;

class Solution {
public:
    string minWindow(string S, string T) {
        string W;
        if (S.length() == 0 || T.length() == 0) return W;    
        int left = INT_MAX;
        
        int min_distance = INT_MAX;
        size_t appears = 0;
        unordered_map<char, int> tar_map;
        unordered_map<char, int> appear_map;
        // map of target character and number it shows
        for (size_t i = 0; i < T.length(); i++) {
            tar_map[T[i]]++;
            appear_map[T[i]] = 0;
        }
        size_t j = 0;
        for (size_t i = 0; i < S.length(); i++) {
            size_t found_pos = T.find(S[i]);
            if (found_pos != string::npos) {
  
                appear_map[S[i]]++;
                if (appear_map[S[i]] <= tar_map[S[i]])
                    appears++;
            }
 
            // substring length is bigger than T
            if (appears == T.length()) {      
                while (((appear_map.find(S[j]) != appear_map.end()) && 
                        (appear_map[S[j]] > tar_map[S[j]])) || 
                        tar_map.find(S[j]) == tar_map.end()) 
                {
                    cout << j << " == " << appear_map[S[j]] << tar_map[S[j]] << endl;
                    if (tar_map.find(S[j]) != tar_map.end())
                        appear_map[S[j]]--;
                    j++;
                }
                
                if (min_distance > i - j + 1) {
                    min_distance = (i - j + 1);
                    left = j;
                }   
            }
        }
    
        if (min_distance == INT_MAX) return string("");
        return S.substr(left, min_distance); 
    }
};

int main() {
    Solution *sol = new Solution();
    string s("bba");
    string res = sol->minWindow(s, string("ab"));
    cout << res << endl;
    return 0;
}
