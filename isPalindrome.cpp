class Solution {
public:
    bool isPalindrome(string s) {
        if (s.length() <= 1) return false;
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        auto left = s.begin();
        auto right = prev(s.end());
        while (left != right) {
             if (!::isalnum(*left)) left++;
             else if(!::isalnum(*right)) right--;
             else if(*left != *right) return false;
        }

        return true;
    }
};
