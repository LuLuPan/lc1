class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
    	if (triangle.size() == 0) return 0;
    	if (triangle.size() == 1) return triangle[0][0];
        for (int i = triangle.size() - 2; i >= 0; i--) {
        	for (int j = 0; j < i + 1; j++) {
        		triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
        	}
        }

        return triangle[0][0];
    }
};