public class Solution {
    // cannot use sort and move toward middle from two side
    // since sort will change index, this question needs to return index
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];

        HashMap<Integer, Integer> index_map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++)
            index_map.put(numbers[i], i);

        for (int i = 0; i < numbers.length; i++) {
            int gap = target - numbers[i];
            if (index_map.containsKey(gap)) {
                // Error here: if 3, 6 -3 = 3, then index is itself
                if (index_map.get(gap) != i) {
                    indices[0] = i + 1;
                    indices[1] = index_map.get(gap) + 1;
                    break;
                }
            }
        }

        return indices;
    }
}