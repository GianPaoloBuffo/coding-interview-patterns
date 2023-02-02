package SlidingWindow;

public class MinimumWindowSubsequence {

    // Time Complexity: O(str1.length() * str2.length())
    // Space Complexity: O(1)
    public static String minWindow(String str1, String str2) {
        int indexS1 = 0;
        int indexS2 = 0;

        int start;
        int end;

        String minimumSubsequence = "";
        int minSubsequenceLength = Integer.MAX_VALUE;

        // for every character of str1
        while (indexS1 < str1.length()) {
            // if characters match, increment indexS2
            if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
                indexS2++;
            }

            // if we've found all characters of str2 in str1
            if (indexS2 == str2.length()) {
                // set start and end to position in str1 where last character of str2 was found
                start = indexS1;
                end = start + 1;

                // move indexS2 back in range
                indexS2--;

                // now, compare both strings again in reverse
                while (indexS2 >= 0) {
                    if (str1.charAt(start) == str2.charAt(indexS2)) {
                        indexS2--;
                    }
                    start--;
                }

                start++;

                // now, we have the substring indexes
                // if this is the smallest substring, update our result
                if (end - start < minSubsequenceLength) {
                    minSubsequenceLength = end - start;
                    minimumSubsequence = str1.substring(start, end);
                }

                // At this point, we've found the FIRST occurrence of the subsequence (iterating forward)
                // We need to check the rest of str1 from this point (for smaller subsequences), so we reset indexS2
                indexS2 = 0;

                // We also need to start checking from within the start of our current subsequence,
                // because the next valid subsequence could start within this one
                indexS1 = start;
            }

            indexS1++;
        }

        return minimumSubsequence;
    }

    public static void main(String[] args) {
        String[] str1 = {
                "abcdebdde",
                "fgrqsqsnodwmxzkzxwqegkndaa",
                "qwewerrty",
                "aaabbcbq",
                "zxcvnhss",
                "alpha",
                "beta",
                "asd",
                "abcd",
                "azstaszaztf"
        };
        String[] str2 = {
                "bde",
                "kzed",
                "werty",
                "abc",
                "css",
                "la",
                "ab",
                "as",
                "pp",
                "saz"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println("-".repeat(100));
        }
    }
}
