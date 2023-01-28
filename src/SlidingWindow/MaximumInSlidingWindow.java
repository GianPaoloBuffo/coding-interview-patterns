package SlidingWindow;

import java.util.*;

public class MaximumInSlidingWindow {

    public static List<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();

        windowSize = Math.min(windowSize, nums.size());

        for (int i = 0; i < windowSize; i++) {
            while (!window.isEmpty() && nums.get(i) >= nums.get(window.peekLast())) {
                window.removeLast();
            }
            window.addLast(i);
        }

        result.add(nums.get(window.peek()));

        for (int i = windowSize; i < nums.size(); i++) {
            while (!window.isEmpty() && nums.get(i) >= nums.get(window.peekLast())) {
                window.removeLast();
            }

            if (!window.isEmpty() && window.peek() <= i - windowSize) {
                window.removeFirst();
            }

            window.addLast(i);
            result.add(nums.get(window.peek()));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-3, -2, -5, -6, -1, -4, -8);
        int windowSize = 3;

        findMaxSlidingWindow(nums, windowSize).forEach(v -> System.out.print(v + " "));
    }
}
