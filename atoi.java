public class Solution {
    public int atoi(String str) {
        int n = str.length();
        int result = 0;
        if (n <= 0) return result;
        int i = 0;
        for (i = 0; i < n; i++)
            if (str.charAt(i) != ' ')
                break;

        int sign = 1;
        if (str.charAt(i) == '+')
            i++;
        else if (str.charAt(i) == '-') {
            i++;
            sign = -1;
        }

        for (int j = i; j < n; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9')
                break;
            int num = str.charAt(j) - '0';
            // notice overflow condition
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + num;
        }

        return result * sign;
    }
}