class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null)
        {
            return null;
        }

       int c = 0;
       ListNode temp = head;
       while(temp != null)
       {
            c++;
            temp = temp.next;
       } 

        if(c == n)
        {
            head = head.next;
            return head;
        }

        if(n > c)
        {
            return head;
        }

        temp = head;
        int i = 0;
        while(i < c-n-1)
        {
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
}       