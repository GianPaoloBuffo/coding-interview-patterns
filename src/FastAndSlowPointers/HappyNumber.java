package FastAndSlowPointers;

public class HappyNumber {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = sumSquareOfDigits(n);

        while (fast != 1 && fast != slow) {
            slow = sumSquareOfDigits(slow);
            fast = sumSquareOfDigits(sumSquareOfDigits(fast));
        }

        return fast == 1;
    }

    private static int sumSquareOfDigits(int number) {
        int totalSum = 0;

        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println("-".repeat(100));
        }
    }
}
