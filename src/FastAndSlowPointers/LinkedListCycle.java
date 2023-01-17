package FastAndSlowPointers;

import Helpers.LinkedList;
import Helpers.LinkedListNode;

public class LinkedListCycle {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slow, fast;
        slow = fast = head;

        if (slow == null) {
            return false;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 9};
        LinkedList<Integer> list = new LinkedList<>();
        list.initLinkedList(elements);

        System.out.println(detectCycle(list.head));
    }
}
