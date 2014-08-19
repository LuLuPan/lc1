#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> results;
        if (n <= 0) return results;
        grayCode(n, results);
        return results;   
    }
private:
    void grayCode(int n, vector<int> &results)
    {
        if (n == 0) {
            results.push_back(0);
            return;
        }
        
        grayCode(n - 1, results);

        size_t len = results.size();
        int mask = (1 << (n - 1));
        for (int i = len - 1; i >= 0; i--) {
    
            results.push_back(mask | results[i]);
        }
    }
};

int main() {
    Solution *sol = new Solution();
    vector<int> result = sol->grayCode(3);
    for (size_t i = 0; i < result.size(); i++)
        cout << result[i] << endl;
    return 0;
}
