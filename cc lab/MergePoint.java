class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergePoint {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(5);
        headA.next.next = intersect;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(7);
        headB.next.next.next = intersect;

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("Merge point value: " + result.val);  // Output: 8
    }
}
