class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        if (matrix.size() == 0) return 0;

        vector<vector<char> > d(matrix);
        int m = matrix.size();
        int n = matrix[0].size();
       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    d[i][j] = d[i][j] == '1' ? 1 : 0;
                    continue;
                }

                d[i][j] = d[i][j] == '1' ? d[i - 1][j] + 1 : 0;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            result = max(result, largestRectangleArea(d[i]));
        }
    }
private:
    int largestRectangleArea(vector<char> &height) {
        if (height.size() == 0) return 0;
        height.push_back(0);
        
        stack<int> st;
        int result = 0;
        for (int i = 0; i < height.size();) {
            if (st.empty() || height[i] > height[st.top()])
                st.push(i++);
            else {
                int idx = st.top();
                st.pop();
                // if st is empty now, it means all previous hist are all higher
                result = max(result, height[idx] * (st.empty() ? i : i - st.top() - 1));
            }
        }

        return result;
    }

};