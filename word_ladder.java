public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 1;
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> depth = new LinkedList<Integer>();

        queue.add(start);
        depth.add(1);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            int steps = depth.poll();
            if (str.equals(end))
                return steps;

            for (int i = 0; i < str.length(); i++) {
                char[] str_array = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    str_array[i] = c;
                    String str_new = String.valueOf(str_array);
                    if (dict.contains(str_new) && !str.equals(str_new)) {
                        queue.add(str_new);
                        depth.add(steps + 1);
                        dict.remove(str_new);
                    }
                }
            }
        }

        return 0;
    }
}