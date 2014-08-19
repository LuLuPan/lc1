class Solution {
public:
    int numDistinct(const string &S, const string &T) {
        if (s.length() == 0) return 0;
        if (T.length() == 0) return 1;

        vector<int> f(T.size() + 1);
        for (int i = 0; i < S.length(); i++) {
            for (int j = T.length() - 1; j >= 0; j--) {
                f[j + 1] = f[j] + (S[i] == T[j] ? f[j] : 0);
            }
        }

        return f[T.size()];
    }
};