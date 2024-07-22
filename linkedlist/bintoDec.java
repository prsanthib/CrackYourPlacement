class Solution {
    public static ListNode rev(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next ;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public int getDecimalValue(ListNode head) {
        int i = 0;
        int value = 0;
        ListNode h1 = rev(head);
        while(h1 != null)
        {
            value += h1.val*Math.pow(2,i);
            i++;
            h1 = h1.next;
        }

        return value;
    }
}