class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        unordered_map<int, bool> used;
        int size = num.size();
        if (size < 2) return size;

        for( auto i : num) 
        	used[i] = false;


        int longest = 1;

        for (auto i : num) {
        	if (used[i] == true) continue;

        	used[i] = true;

            int len = 1;
        	for (int j = i + 1; used.find(j) != used.end(); j++) {
        		used[j] = true;
        		len++;
        	}

        	for (int j = i - 1; used.find(j) != used.end(); j--){
        		used[j] = true;
        		len++;
        	}

        	longest = max(longest, len);
        }

        return longest;
    }
};