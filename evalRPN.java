public class Solution {
    private boolean isOperator(String o) {
        if (o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/"))
            return true;
        return false;
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int intermediate = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            if (!isOperator(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else {
                if (stack.size() >= 2) {
                    int a = stack.peek();
                    stack.pop();
                    int b = stack.peek();
                    stack.pop();

                    if (tokens[i].equals("+"))
                        intermediate = a + b;
                    else if (tokens[i].equals("-"))
                        intermediate = b - a;
                    else if (tokens[i].equals("*"))
                        intermediate = a * b;
                    else if (tokens[i].equals("/"))
                        intermediate = b / a;

                    stack.push(intermediate);
                }
            }
        }
        // in case of only one operaton
        if (stack.size() == 1)
            intermediate = stack.peek();
        return intermediate;
    }
}