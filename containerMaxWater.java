public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, area);
            // move to right if left side is shorter than right
            // move to left if right side is shorter than left
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return result;
    }
}