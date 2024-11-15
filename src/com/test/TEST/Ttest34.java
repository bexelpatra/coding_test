package com.test.TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ttest34 {
    public static List<int[]> mergeRanges(List<int[]> ranges) {
        // Sort ranges by start values
        ranges.sort(Comparator.comparingInt(range -> range[0]));

        List<int[]> mergedRanges = new ArrayList<>();
        int[] currentRange = ranges.get(0);

        for (int i = 1; i < ranges.size(); i++) {
            int[] nextRange = ranges.get(i);

            // Check if ranges overlap or are adjacent
            if (nextRange[0] < currentRange[1]) {
                // Merge ranges by updating the end to the max end of both
                currentRange[1] = Math.max(currentRange[1], nextRange[1]);
            } else {
                // Add the non-overlapping range to the result and update current range
                mergedRanges.add(currentRange);
                currentRange = nextRange;
            }
        }

        // Add the last range
        mergedRanges.add(currentRange);

        return mergedRanges;
    }

    public static void main(String[] args) {
        // Example ranges to merge
        List<int[]> ranges = new ArrayList<>(Arrays.asList(
            new int[]{5, 11},
            new int[]{11, 22},
            new int[]{11, 22},
            new int[]{25, 30},
            new int[]{28, 35}
        ));

        List<int[]> mergedRanges = mergeRanges(ranges);

        System.out.println("Merged Ranges:");
        for (int[] range : mergedRanges) {
            System.out.println(Arrays.toString(range));
        }
    }
}