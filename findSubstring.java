public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int cat_len = L[0].length() * L.length;
        int str_len = S.length();
        int word_len = L[0].length();
        List<Integer> result = new ArrayList<Integer>();
        if (str_len < cat_len) return result;

        List<Integer> indices = new ArrayList<Integer>();
        dfs(S, L, 0, 0, indices, result);
        return result;
    }

    private void dfs(String S, String[] L, int start, int steps, 
        List<Integer> indices, List<Integer> result) {
        if (steps == L.length) {
            result.add(indices.get(0));
            return;
        }

        if (S.length() - start < L[0].length() * L.length)
            return;

        for (int i = start; i < S.length() - L[0].length(); i++) {
            if (Arrays.asList(L).contains(S.substring(i, i + L[0].length()))) {
                indices.add(i);
                dfs(S, L, i + L[0].length(), steps + 1, indices, result);
                indices.clear();
                steps = 0;
            }
        }
    }
}



public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int cat_len = L[0].length() * L.length;
        int str_len = S.length();
        int word_len = L[0].length();
        List<Integer> result = new ArrayList<Integer>();
        if (str_len < cat_len) return result;

        HashMap<String, Integer> word_map = new HashMap<String, Integer>();
        for (String word : L) {
            if (word_map.containsKey(word))
                word_map.put(word, word_map.get(word) + 1);
            else
                word_map.put(word, 1);
        }
        // should be: i < S.length() - cat_len + 1
        for (int i = 0; i < S.length() - cat_len + 1; i++) {
            HashMap<String, Integer> words = new HashMap<String, Integer>(word_map);
            for (int j = i; j < i + cat_len; j += word_len) {
                String word = S.substring(j, j + word_len);
                if (!Arrays.asList(L).contains(word) || !words.containsKey(word))
                    break;
                words.put(word, words.get(word)- 1);
                if (words.get(word) == 0)
                    words.remove(word);
            }

            if (words.isEmpty())
                result.add(i);
        }

        return result;
    }
}