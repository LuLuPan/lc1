class Solution {
public:
	string simplifyPath(string path) {
		if (path.length() == 0) return path;

		vector<string> folders;
		for (auto cur = path.begin(); cur != path.end();) {
			cur++; // skip first '/'
			auto j = find(cur, path.end(), '/');
			string folder = string(i, j);

			if (!folder.empty() && folder != ".") {
				if (folder == "..") {
					if (!folders.empty())
						folders.pop_back();
				} else folders.push_back(folder);
			}

			i = j;
		}

		stringstream out;
		if (folders.empty())
			out << "/";
		else {
			for (auto folder : folders)
				out << '/' << folder;
		}

		return out.str();
	}
};