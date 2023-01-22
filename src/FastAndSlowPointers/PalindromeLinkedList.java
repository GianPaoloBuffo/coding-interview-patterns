package FastAndSlowPointers;

import Helpers.LinkedList;
import Helpers.LinkedListNode;

public class PalindromeLinkedList {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode reversedSecondHalf = reverse(slow);

        while (reversedSecondHalf != null) {
            if (head.data != reversedSecondHalf.data) {
                return false;
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;
    }

    private static LinkedListNode reverse(LinkedListNode node) {
        LinkedListNode prev = null;
        LinkedListNode current = node;
        LinkedListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;

        return node;
    }

    public static void main(String[] args) {
        int[] elements = {6, 1, 0, 5, 1, 6};
        LinkedList<Integer> list = new LinkedList<>();
        list.initLinkedList(elements);

        System.out.println(palindrome(list.head));
    }
}
