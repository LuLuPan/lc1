public class Solution {
    public String intToRoman(int num) {
        final int[] radix = new int[] {1000, 900, 500, 400, 100,
            90, 50, 40, 10, 9, 5, 4, 1};

        final String[] symbol = new String[] {"M", "CM", "D", "CD", "C",
            "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = new String();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num %= radix[i];
            for (; count > 0; count--)
                roman += symbol[i];
        }

        return roman;
    }
}