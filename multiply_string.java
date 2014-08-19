public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return null;

        int[] num = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int carrier = 0;
            int a = num1.charAt(num1.length() - 1 - i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(num2.length() - 1 - j) - '0';
                // should be accumulated
                num[i + j] += a * b + carrier;
                carrier = num[i + j] / 10;
                num[i + j] %= 10;
            }
            num[i + num2.length()] += carrier;
        }

        int i = num.length - 1;
        while (i >= 0 && num[i] == 0)
            i--;
        // if one of string is "0", num has all 0
        if (i < 0)
            return "0";
        StringBuilder sb = new StringBuilder("");
        while (i >= 0)
            sb.append((char)(num[i--] + '0'));

        return sb.toString();
    }
}