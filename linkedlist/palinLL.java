class Solution {

    public static ListNode rev(ListNode s)
    {
        ListNode prev = null;
        ListNode curr = s;
        ListNode next;

        while(curr !=  null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPal(ListNode h1 , ListNode h2)
    {
        while(h1 != null && h2 != null)
        {
            if(h1.val != h2.val)
            {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        return true;
    }
    public boolean isPalindrome(ListNode head) {
        //find mid
        if(head == null || head.next == null)
        {
            return true;
        }

        ListNode s = head;
        ListNode f = head;
        ListNode prev = head;
        while(f != null && f.next != null)
        {
            prev = s;
            s = s.next;
            f = f.next.next;
        }

        prev.next = null;
        ListNode revhead = rev(s);
        
        return isPal(head,revhead);
    }
}