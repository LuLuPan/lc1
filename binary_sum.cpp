class Solution {
public:
    string addBinary(string a, string b) {
        if (a.empty()) return b;
        if (b.empty()) return a;
        string result;
        int n = a.size() > b.size() ? a.size() : b.size();

        reverse(a.begin(), a.end());
        reverse(b.being(), b.end());
        int carrier = 0;
        for (int i = 0; i < n; i++) {
            int ai = i < a.size() ? a[i] - '0' : 0;
            int bi = i < b.size() ? b[i] - '0' : 0;
            int val = (ai + bi + carrier) % 2;
            carrier = (ai + bi + carrier) / 2;
            result.insert(result.begin(), val + '0');
        }

        if (carrier == 1)
            result.insert(result.begin(), '1');

        return result;
    }
};