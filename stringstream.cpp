#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main() {
    string s("    ");
    stringstream ss(s);
    string buf;
    while (ss >> buf)
        cout << buf << endl;

    return 0;
}
