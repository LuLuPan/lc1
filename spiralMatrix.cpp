class Solution {
public:
    vector<int> matrixOrder(vector<vector<int> > &matrix) {
        vector<int> results;
        if (matrix.empty()) results;
        size_t beginX = 0, endX = matrix[0].size() - 1;
        size_t beginY = 0, endY = matrix.size() - 1;

        while (1) {
            // -->
            for (size_t i = beginX; i <= endX; i++)
                results.push_back(matrix[beginY][i]);
            if (++beginY > endY) break;
            //  |
            //  v
            for (size_t i = beginY; i <= endY; i++)
                results.push_back(matrix[i][endX]);
            if (beginX > --endX) break;
            // <--
            for (size_t i = endX; i >= beginX; i--)
                results.push_back(matrix[endY][i]);
            if (beginY > --endX) break;
            // ^
            // |
            for (size_t i = endY; i >= beginY; i--)
                results.push_back(matrix[i][beginX]);
            if (++beginX > endX) break;
        }

        return results;
    }
};