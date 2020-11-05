package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextList = slow;
        prev.next = null;

        return nextList;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }

        // ensures that list1's first value is less than list2 first value
        if (list1.val > list2.val) {
            return mergeLists(list2, list1);
        }

        return merge(list1, list2);
    }


    public static ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }

        list2.next = merge(list1, list2.next);
        return list2;
    }
}
