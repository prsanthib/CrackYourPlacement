class Solution {
    public static ListNode getMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode left , ListNode right)
    {
        if(left == null)
        {
            return right;
        }

        if(right == null)
        {
            return left;
        }

        ListNode res;
        if(left.val <= right.val)
        {
            res = left;
            res.next = merge(left.next , right);
        }
        else
        {
            res = right;
            res.next = merge(left , right.next);
        }

        return res;
    }

    public static ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(head2);

        
        return merge(left,right);
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}