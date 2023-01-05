package dsatutorial.codinginterviwqestions;

/*
-------------------- Insert Interval - LeetCode #57 --------------------
You are given an array intervals of non-overlapping intervals where
intervals[i] = [starti, endi] represent the start and the end of the
ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that
represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted
in ascending order by starti and intervals still does not have any
overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
------------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return intervals;

        List<int[]> list = new ArrayList<>();

        int i = 0; // traverse intervals
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 1},
                             {3, 5},
                             {6, 7},
                             {9, 10}
                            };
        int[][] result = insert(intervals, new int[] {2, 7});

        printArray(result);
    }
}
