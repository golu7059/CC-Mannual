class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        SwapNodes swapNodes = new SwapNodes();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode swapped = swapNodes.swapPairs(head);
        System.out.print("After swapped : ");

        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
    }
}
