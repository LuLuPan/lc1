public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int n = s.length();
        // not good to use hashmap to store index, since one duplication has
        // been found, all num before the first dup one become useless,
        // and if remove them will make complexity to O(n^2)
        //HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //HashSet<Character> set = new HashSet<Character>();
        int max_len = 0;
        // arrays to store character and its latest position
        // Cannot use 26 since other char other than 'a' to 'z' may occur
        int[] nums = new int[255];
        Arrays.fill(nums, -1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (nums[s.charAt(i)] >= start) {
                // duplicated
                max_len = Math.max(max_len, i - start);
                start = nums[s.charAt(i)] + 1;
            }
            nums[s.charAt(i)] = i;
        }
        max_len = Math.max(s.length() - start, max_len);
        return max_len;
    }
}