class Solution {
    public static ListNode rev(ListNode l1)
    {
        ListNode prev = null;
        ListNode curr = l1;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = rev(l1);
        ListNode h2 = rev(l2);
        ListNode t1 = h1;
        ListNode t2 = h2;
        int c = 0;
        int n = 0;

        int sum  = t1.val + t2.val;
        n = sum%10;
        c = sum/10;

        ListNode head = new ListNode(n);
        ListNode temp = head;
        t1 = t1.next;
        t2 = t2.next;

        while(t1 != null && t2 != null)
        {
            sum  = t1.val + t2.val + c;
            n = sum%10;
            c = sum/10;
            temp.next = new ListNode(n);
            temp = temp.next; 
            t1 = t1.next;
            t2 = t2.next;            
        }

        while(t1 != null)
        {
            sum  = t1.val + c;
            n = sum%10;
            c = sum/10;
            temp.next = new ListNode(n);
            temp = temp.next; 
            t1 = t1.next;
        }

        while(t2 != null)
        {
            sum  = t2.val + c;
            n = sum%10;
            c = sum/10;
            temp.next = new ListNode(n);
            temp = temp.next; 
            t2 = t2.next;
        }

        if(c == 1)
        {
            temp.next = new ListNode(1);
            temp = temp.next;
        }
        return rev(head);
    }
}