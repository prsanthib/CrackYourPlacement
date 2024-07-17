class Solution {
    public static ListNode rev(ListNode head)
    {
        ListNode next;
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode currhead = head;
        ListNode temp = head;
        ListNode prev = null;
        
        while(currhead != null)
        {
            temp = currhead;
            for(int i = 0 ; i < k-1 ; i++)
            {
                temp = temp.next;
                if(temp == null){
                    break;
                }
            }
            if(temp == null)
            {
                break;
            }
            ListNode nxthead = temp.next;
            temp.next = null;
            ListNode revhead = rev(currhead);
            currhead.next = nxthead;
            if(prev == null)
            {
                head = revhead;
            }
            else
            {
            prev.next = revhead;
            }
            prev = currhead;
            currhead = nxthead;
        }

        return head;
    }
}