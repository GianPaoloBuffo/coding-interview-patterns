package SlidingWindow;

import java.util.*;

public class MaximumInSlidingWindow {

    public static List<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();

        windowSize = Math.min(windowSize, nums.size());

        // todo: implement solution

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int windowSize = 3;

        findMaxSlidingWindow(nums, windowSize).forEach(System.out::print);
    }
}
