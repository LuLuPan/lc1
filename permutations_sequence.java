public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        if (n <= 0) return result.toString();
        boolean[] visited = new boolean[n];
        int[] count = new int[1];
        count[0] = 0;
        dfs(n, k, count, visited, 0, "", result);
        return result.toString();
    }

    private void dfs(int n, int k, int[] count, boolean[] visited, int steps, String path, StringBuilder result) {
        if (steps == n) {
            count[0]++;
            if (count[0] == k) {
                result.append(path);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1] == false) {
                visited[i - 1] = true;
                String num = Integer.toString(i);
                dfs(n, k, count, visited, steps + 1, path + num, result);
                visited[i - 1] = false;
            }
        }
    }
}


public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        if (n <= 0) return result.toString();
        int[] num = new int[n];
        int permcount = 1;
        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
            permcount *= i;
        }
        
        // change K from (1,n) to (0, n-1) to accord to index  
        k--; 
        // first number is  k/(n-1)!
        for (int i = 0; i < n; i++) {
            permcount /= (n - i);
            int choosed = k / permcount;
            result.append(Integer.toString(num[choosed]));
            // for input 1, 1: j + 1 will exceed bounds
            for (int j = choosed; j < Math.min(n - i, n - 1); j++)
                num[j] = num[j + 1];
            k %= permcount;            
        }

        return result.toString();
    }
}