public class Solution {

    private int map(Character c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map(s.charAt(i)) > map(s.charAt(i - 1)))
                result += map(s.charAt(i)) - 2 * map(s.charAt(i - 1));
            else
                result += map(s.charAt(i));
        }

        return result;
    }
}