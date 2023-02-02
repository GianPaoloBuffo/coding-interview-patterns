package SlidingWindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public static List<String> findRepeatedSequences(String s, int k) {
        Set<String> seenSequences = new HashSet<>();
        Set<String> repeatedSequences = new HashSet<>();

        for (int i = 0; i < s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            if (!seenSequences.add(substring)) {
                repeatedSequences.add(substring);
            }
        }

        return repeatedSequences.stream().toList();
    }

    public static void main(String[] args) {
        String s = "GGGGGGGGGGGGGGGGGGGGGGGGG";
        int k = 12;
        findRepeatedSequences(s, k).forEach(System.out::println);
    }
}
