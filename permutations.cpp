class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > result;
        if (num.size() == 0) return result;
        vector<int> path;
        
        dfs(num, path, result);
        return result;
    }
private:
    void dfs(const vector<int> &num, vector<int> &path, vector<vector<int> >& result) {
        if (path.size() == num.size()) {
            result.push_back(path);
            return;
        }
        
        for (auto i : num) {
            auto pos = find(path.begin(), path.end(), i);
            if (pos == path.end()) {
                path.push_back(i);
                dfs(num, path, result);
                path.pop_back();
            }
        }
    }
};
