/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n == 0) return 0;
        int result = 1;

        HashMap<Double, Integer> slope_map = new HashMap<Double, Integer>();

        for (int i = 0; i < n - 1; i++) {
            // for each point, find all slopes across it
            slope_map.clear();
            Double slope = 0.0;
            int max_pts = 1;
            int same_pts = 0;

            for (int j = i + 1; j < n; j++) {
                if (points[i].x == points[j].x) {
                    slope = Double.POSITIVE_INFINITY;
                    if (points[i].y == points[j].y) {
                        same_pts++;
                        continue;
                    }
                } else {
                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                    // -0.0 is valid for double, just ignore it
                    if (points[i].y == points[j].y)
                        slope = 0.0;
                }

                if (slope_map.containsKey(slope))
                    slope_map.put(slope, slope_map.get(slope) + 1);
                else
                    slope_map.put(slope, 2);

                // update max points
                max_pts = Math.max(max_pts, slope_map.get(slope));
            }

            result = Math.max(result, max_pts + same_pts);
        }

        return result;
    }
}