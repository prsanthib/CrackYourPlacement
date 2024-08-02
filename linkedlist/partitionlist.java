class Solution {
    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode t1 = h1;
        ListNode t2 = h1;

        ListNode temp = head;
        while(temp != null)
        {
            if(temp.val < x)
            {
                if(h1 == null)
                {
                    h1 = t1 = temp;
                    temp = temp.next;
                    if(t1!=null)
                    {
                        t1.next = null;
                    }
                }
                else
                {
                    t1.next = temp;
                    temp = temp.next;
                    t1 = t1.next;
                    if(t1!=null)
                    {
                        t1.next = null;
                    }
                }
            }
            else
            {
                if(h2 == null)
                {
                    h2 = t2 = temp;
                    temp = temp.next;
                    if(t2!=null)
                    {
                        t2.next = null;
                    }
                }
                else
                {
                    t2.next = temp;
                    temp = temp.next;
                    t2 = t2.next;
                    if(t2!=null)
                    {
                        t2.next = null;
                    }
                }
            }
        }

        if(h1 == null)
        {
            return h2;
        }
        if(h2 == null)
        {
            return h1;
        }
        t1.next = h2;
        return h1;
    }
}