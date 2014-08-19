public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> text = new ArrayList<String>();
        if (words.length == 0) return text;
        int n = words.length;
        int space_num = 0;
        int cur_len = 0;
        int cur_start = 0;
        int cur_end = 0;
        for (int i = 0; i < n; i++) {
            if ((cur_len + words[i].length() + (i - cur_start)) > L) {
                StringBuilder line = form_line(words, L, cur_len, cur_start, i - 1, false);
                text.add(line.toString());
                cur_start = i;
                cur_len = 0;
            }
            cur_len += words[i].length();
        }

        // last line
        StringBuilder line = form_line(words, L, cur_len, cur_start, n - 1, true);
        text.add(line.toString());
        return text;
    }

    private StringBuilder form_line(String[] words, int L, int cur_len, int start, 
        int end, boolean is_last)
    {
        int space_pos = end - start;
        int[] space_nums = new int[space_pos];
        int i = 0;
        while (space_pos != 0 && i < L - cur_len) {
            space_nums[i % space_pos] += 1;
            i++;
            // for last line, 1 space between word and let right side has most space
            if (i == space_pos && is_last)
                break;
        }
        StringBuilder line_sb = new StringBuilder();
        for (i = start; i <= end; i++) {
            line_sb.append(words[i]);
            if (space_pos > 0 && i != end) {
                int num = space_nums[i - start];
                char[] spaces = new char[num];
                Arrays.fill(spaces, ' ');
                line_sb.append(spaces);
            }
        }

        if (line_sb.length() < L) {
            char[] spaces = new char[L - line_sb.length()];
            Arrays.fill(spaces, ' ');
            line_sb.append(spaces);
        }

        return line_sb;
    }
}