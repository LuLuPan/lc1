public class Solution {
    public enum input_type {
        INVALID,
        SPACE,
        SIGN,
        DIGIT,
        DOT,
        EXP,
        INPUT_NUM
    }
    // finite automata machine
    static int[][] state_table = {
        {-1,  0,  3,  1,  2, -1},//state when no input or just space  
        {-1,  8, -1,  1,  4,  5},//state after input digits  
        {-1, -1, -1,  4, -1, -1},//state after input dot and no digit before  
        {-1, -1, -1,  1,  2, -1},//state after input sign and no digit before  
        {-1,  8, -1,  4, -1,  5},//state with digits and dot before  
        {-1, -1,  6,  7, -1, -1},//state after input E
        {-1, -1, -1,  7, -1, -1},//state after input E and followed by sign  
        {-1,  8, -1,  7, -1, -1},//state after input E and followed by digit  
        {-1,  8, -1, -1, -1, -1}//state after valid input and followed space
    };
    public boolean isNumber(String s) {
        int n = s.length();
        if (n == 0) return false;
        input_type input = input_type.INVALID;
        int state = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '.')
                input = input_type.DOT;
            else if (c == 'E' || c == 'e')
                input = input_type.EXP;
            else if (c == '-' || c == '+')
                input = input_type.SIGN;
            else if (c == ' ')
                input = input_type.SPACE;
            else if (c >= '0' && c <= '9')
                input = input_type.DIGIT;
            else
                input = input_type.INVALID;

            state = state_table[state][input.ordinal()];
            if (state == -1)
                return false;
        }

        return state == 1 || state == 4 || state == 7 || state == 8;
    }
}