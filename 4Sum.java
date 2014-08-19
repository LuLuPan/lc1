public class Solution {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 4) return result;

        Arrays.sort(num);

        HashMap<Integer, List<Pair>> index_map = new HashMap<Integer, List<Pair>>();
        // put 2sum value and indicies pair into map
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (index_map.containsKey(sum)) {
                    index_map.get(sum).add(new Pair(i, j));
                }
                else {
                    List<Pair> pairs = new ArrayList<Pair>();
                    pairs.add(new Pair(i, j));
                    index_map.put(sum, pairs);
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int diff = target - num[i] - num[j];
                if (index_map.containsKey(diff)) {
                    List<Pair> pairs = new ArrayList<Pair>();
                    pairs = index_map.get(diff);
                    for (Pair pair : pairs) {
                        // skip overlaping
                        if (i <= pair.second)
                            continue;
                        int a = num[pair.first];
                        int b = num[pair.second];
                        int c = num[i];
                        int d = num[j];
                        List<Integer> tmp = Arrays.asList(a, b, c, d);
                        if (set.add(tmp))
                            result.add(tmp);
                    }
                }
            }
        }

        return result;
    }
}