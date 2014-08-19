class Solution {
public:
    string countAndSay(int n) {
        string s("1");
        while(--n) {
            s = genNext(s);
        }
        
        return s;
   }

private:
    string genNext(string s) {
        string ss;
        for (auto i = s.begin(); i != s.end(); i++) {
            auto j = find_if(i, s.end(), bind1st(not_equal_to<char>(), *i));
            ss << distance(i, j) << *i;
            i = j;
        }
    }
};
