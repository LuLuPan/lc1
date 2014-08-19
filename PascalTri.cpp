class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int> > results;
        if (numRows <= 0) return results;
        vector<int> first(1, 1);
        results.push_back(first);
        for (int i = 2; i <= numRows; i++) {
        	std::vector<int> v(i, 1);
        	const std::vector<int> &last = results[i - 2];

        	for (int j = 1; j < i - 1; j++)
        		v[j] = last[j - 1] + last[j];
        	results.push_back(v);
        }

        return results;
    }
};
