package dsatutorial.codinginterviwqestions;

/*
-------------------- Merge Intervals - LeetCode #56 --------------------
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the
non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them
into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
------------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= end) {
                end = Math.max(end, current[1]);
            } else {
                list.add(new int[] {start, end});
                start = current[0];
                end = current[1];
            }
        }
        list.add(new int[] {start, end});
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
        int[][] intervals = {{7, 9},
                             {2, 6},
                             {1, 3}
                             };
        int[][] result = mergeIntervals(intervals);

        printArray(result);
    }
}
