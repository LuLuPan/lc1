public class Solution {
    // stack based, Time: O(n) Space: O(n)
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int n = s.length();

        Stack<Integer> stack = new Stack<Integer>();
        // position of last unmatched ')'
        int last = -1;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty()) {
                    // unmatched ')'
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        max_len = Math.max(max_len, i - last);
                    else
                        max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }

        return max_len;
    }
}

public class Solution {
    // two round traversal, Time: O(n) Space: O(1)
    // one of them will find max, determined which side has less unmatches
        // stack based, Time: O(n) Space: O(n)
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int n = s.length();

        // position of last unmatched ')'
        int last = -1;
        int max_len = 0;
        // track match or not
        //start from left to right
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                depth++;
            else {
                depth--;
                if (depth == 0)
                    max_len = Math.max(max_len, i - last);
                else if (depth < 0) {
                    // unmatched ')' found
                    last = i;
                    depth = 0;
                }
            }
        }

        depth = 0;
        last = n;
        // start from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                depth++;
            else {
                depth--;
                if (depth == 0) {
                    // matched with "("
                    max_len = Math.max(max_len, last - i);
                } else if (depth < 0) {
                    // unmatched '('
                    last = i;
                    depth = 0;
                }
            }
        }

        return max_len;
    }
}