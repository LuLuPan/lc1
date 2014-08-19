class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        vector<vector<int> > result;
        size_t n = S.size();
        if (n == 0) return result;
        sort(S.begin(), S.end());
        vector<bool> select(n, false);
        subsets(S, select, 0, result);
        return result;
    }
private:
    void subsets(vector<int> &S, vector<bool> &select, int step, 
                 vector<vector<int> > &result) {
        if (step == S.size()) {
            vector<int> v;
            for (size_t i = 0; i < S.size(); i++) {
                if (select[i]) v.push_back(S[i]);
            }
            result.push_back(v);
            return;
        }
        
        // not select S[step]
        select[step] = false;
        subsets(S, select, step + 1, result);
        // select S[step]
        select[step] = true;
        subsets(S, select, step + 1, result);
    }
};
