/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) return intervals;
        vector<Interval>::iterator it = intervals.begin();
        while (it != intervals.end()) {
        	vector<Interval>::iterator next = it + 1;
        	if (next != intervals.end()) {
        		if (it->end >= next->start) {
        			Interval newInterval(it->start, next->end);
        			it = intervals.erase(it);
        			intervals.insert(it, newInterval);
        		} else {
        			it++;
        		}
        	}
        }
        return intervals;
    }
};