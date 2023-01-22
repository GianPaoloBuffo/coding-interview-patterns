package FastAndSlowPointers;

import Helpers.LinkedList;
import Helpers.LinkedListNode;

public class MiddleOfLinkedList {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5};
        LinkedList<Integer> list = new LinkedList<>();
        list.initLinkedList(elements);

        System.out.println(middleNode(list.head));
    }
}
