package Arrays;

import java.util.ArrayList;

public class MergeIntervals {

/*
Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals

 */
    static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start+"-"+end;
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> req = new ArrayList<>();
        req.add(new Interval(1, 3));
        req.add(new Interval(6, 9));

        ArrayList<Interval> resp = insert(req, new Interval(2, 5));
        System.out.println(resp.toString());
    }   

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if(curInterval.end<newInterval.start){
                res.add(curInterval);
            } else if(newInterval.end<curInterval.start) {
                res.add(newInterval);
                while(i<intervals.size()) {
                    res.add(intervals.get(i));
                    i++;
                }
                return res;
            } 
            //Merge
            else {
                newInterval = new Interval(Math.min(curInterval.start, newInterval.start), Math.max(curInterval.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
}
