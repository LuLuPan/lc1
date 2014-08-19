class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<string> result;
        if (strs.size() == 0) return result;
        unordered_map<string, int> check_map;
        for (size_t i = 0; i < strs.size(); i++) {
            string key = strs[i];
            sort(key.begin(), key.end());
            if (check_map.find(key) == check_map.end()) {
                // first time, store index
                check_map[key] = i;
            } else {
                int j = check_map[key];
                if (j != -1) {
                    // insert the first one
                    result.push_back(strs[j]);
                    check_map[key] = -1;
                }
                result.push_back(strs[i]);
            }
        }
     
        return result;
    }
};
