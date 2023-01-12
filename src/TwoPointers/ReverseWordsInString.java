package TwoPointers;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords(" Hello  How are you I am well thanks how are you yes"));
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static String reverseWords(String sentence) {
        return "Implement me";
    }

    private static String trimSpaces(String string) {
        return string.replaceAll("\\s+", " ").trim();
    }

    private static void reverseStringInPlace(StringBuilder string, int start, int end) {
        while (start < end) {
            char temp = string.charAt(end);
            string.setCharAt(end--, string.charAt(start));
            string.setCharAt(start++, temp);
        }
    }
}
