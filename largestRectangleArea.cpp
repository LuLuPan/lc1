#include <iostream>
#include <stack>
#include <vector>
using namespace std;
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        if (height.size() == 0) return 0;
        stack<int> st;
        height.push_back(0);
        int result = 0;
        for (int i = 0; i < height.size();) {
            if (st.empty() || height[i] > height[st.top()])
                st.push(i++);
            else {
                int idx = st.top();
                st.pop();
                result = max(result, height[idx] * (st.empty() ? i : i - st.top() - 1));
            }
        }

        return result;
    }
};

int main() {
    vector<int> height;
    height.push_back(3);
    height.push_back(2);

    Solution *sol = new Solution;
    int ret = sol->largestRectangleArea(height);
    cout << ret << endl;
    return 0;
}