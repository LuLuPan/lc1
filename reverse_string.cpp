class Solution {
public:
    void reverseWords(string &s) {
    	if (s.length() == 0) return;
    	stringstream ss(s);
    	vector<string> words;
    	string buf;
    	//string stream expects space as delimiter
    	while (ss >> buf) {
    		words.push_back(buf);
    	}

    	s.clear();

    	if (words.size() == 0)
    		return;

    	for (size_t i = words.size() - 1; i >= 1; i--) {
    		s.append(words[i]);
    		s.append(" ");
    	}
    	s.append(words[0]);
    }
};


class Solution {
public:
    void reverseWords(string &s) {
    	if (s.length() == 0) return;

        string rs;
    	for (size_t i = s.length() - 1; i >= 0;) {
    		while (s[i] == ' ' && i >=0) i--;

    		if (!rs.empty()) rs.push_back(' ');

            string t;
    		while (s[i] != ' ' && i >= 0)
    			t.push_back(s[i--]);

    		reverse(t.begin(), t.end());

    		rs.append(t);
    	}

    	s  = rs;
    }
};