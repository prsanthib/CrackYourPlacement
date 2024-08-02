class Solution {

    public static ListNode reverse(ListNode slow)
    {
        if(slow == null || slow.next == null)
        {
            return slow;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode h2 = reverse(slow);        
        ListNode h1 = head;

        ListNode res = head;
        ListNode temp = res;
        h1 = h1.next;

        while(h1 != null && h2 != null)
        {
            temp.next = h2;
            temp = temp.next;
            h2 = h2.next;
             
            if(h1 != null)
            {
                temp.next = h1;
                temp = temp.next;
                h1 = h1.next;
            }
        }

        while(h1 != null)
        {
            temp.next = h1;
            temp = temp.next;
            h1 = h1.next;
        }

        while(h2 != null)
        {
            temp.next = h2;
            temp = temp.next;
            h2 = h2.next;
        }

        head = res;
    }
}