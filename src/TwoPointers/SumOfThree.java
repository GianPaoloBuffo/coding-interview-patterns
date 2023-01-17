package TwoPointers;

import java.util.Arrays;

public class SumOfThree{

    // Time Complexity: O(nlog(n)) for sort + O(n^2) for loop = O(nlog(n) + n^2)
    // Space Complexity: O(1)
    private static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);

        int low, high, sum;

        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];

                if (sum == target) {
                    return true;
                }

                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};

        int[][] testList = {{10, 20, 21},
                {-8, 0, 7},
                {8, 10, 20},
                {1, -1, 0},
                {8, 11, 15}};

        for (int i=0; i<testList.length; i++) {
            System.out.print(i+1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));
            for(int j=0 ;j<testList[i].length; j++){
                if (findSumOfThree(numsList[i], testList[i][j])) {
                    System.out.println("\tSum for " + testList[i][j] + " exists ");
                } else {
                    System.out.println("\tSum for " + testList[i][j] + " does not exist ");
                }
            }
            System.out.println(("-".repeat(100)));
        }
    }
}
