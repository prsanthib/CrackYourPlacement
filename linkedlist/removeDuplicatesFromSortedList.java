class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode temp = head;
        int val = head.val;
        while(temp.next != null)
        {
            if(temp.next.val == val)
            {
                temp.next = temp.next.next;
            }
            else
            {
                val = temp.next.val;
                temp = temp.next;
            }
        }
        return head;
    }
}