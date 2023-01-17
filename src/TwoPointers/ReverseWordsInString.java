package TwoPointers;

public class ReverseWordsInString {

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static String reverseWords(String sentence) {
        String trimmed = trimSpaces(sentence);
        String[] words = trimmed.split(" ");

        reverseInPlace(words);

        return String.join(" ", words);
    }

    private static String trimSpaces(String string) {
        return string.replaceAll("\\s+", " ").trim();
    }

    private static void reverseInPlace(String[] words) {
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            String temp = words[end];
            words[end--] = words[start];
            words[start++] = temp;
        }
    }

    public static void main(String[] args) {
        String[] inputs = {"Hello World!", "We love Python.", "The quick brown fox jumped over the lazy dog.", "Hey!", "To be, or not to be", "AAAAA", "Hello     World"};
        for(int i=0; i<inputs.length; i++){
            System.out.print(i+1);
            System.out.println(".\tActual string:\t\t"+ inputs[i]);
            System.out.println("\tReversed String:\t"+ reverseWords(inputs[i]));
            System.out.println("-".repeat(100));
        }
    }
}
