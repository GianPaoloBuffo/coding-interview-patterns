package FastAndSlowPointers;

public class CircularArrayLoop {

    // Time Complexity: O(n) ?
    // Space Complexity: O(1)
    public static boolean circularArrayLoop(int[] nums) {
        int old;
        int iterations = 0;
        int slow = 0, fast = 0;
        int max = nums.length;

        while (iterations < max) {
            iterations++;

            old = slow;
            slow = movePointer(slow, nums[slow], max);
            if (oppositeSigns(nums[old], nums[slow])) {
                fast = slow = iterations;
                continue;
            }

            old = fast;
            fast = movePointer(fast, nums[fast], max);
            if (oppositeSigns(nums[old], nums[fast])) {
                fast = slow = iterations;
                continue;
            }

            old = fast;
            fast = movePointer(fast, nums[fast], max);
            if (oppositeSigns(nums[old], nums[fast])) {
                fast = slow = iterations;
                continue;
            }

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static int movePointer(int pointer, int moves, int max) {
        return Math.floorMod(pointer + moves, max);
    }

    private static boolean oppositeSigns(int num1, int num2) {
        return (num1 >= 0) == (num2 < 0);
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1, -1, -1, -1, -1};
        System.out.println(circularArrayLoop(arr));
    }
}
