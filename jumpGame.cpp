class Solution {
public:
    bool canJump(int A[], int n) {
        int reach = 1;
        for (int i = 0; i < reach && reach < n; i++) {
            reach = max(reach, i + A[i] + 1);
        }

        return reach >= n;
    }
}