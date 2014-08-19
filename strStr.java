public class Solution {
    public String strStr(String haystack, String needle) {
        assert(haystack != null && needle != null);
        if (haystack.length() < needle.length()) return null;
        if (needle.length() == 0) return haystack;
        int start = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                int k = i;
                while (k < haystack.length() && j < needle.length()) {
                    if (haystack.charAt(k) != needle.charAt(j))
                        break;
                    k++;
                    j++;
                }

                if (j == needle.length()) {
                    // found
                    return haystack.substring(i, haystack.length());
                }
            }
        }


        return null;
    }
}