class sort012
{
    static class Node
    {
        int val;
        Node next;
        public Node(int v)
        {
            val = v;
            next = null;
        }
    }

    public static Node sort(Node head)
    {
        if(head == null)
        {
            return null;
        }

        int c1 = 0;
        int c2 = 0;
        int c0 = 0;

        Node temp = head;

        while(temp != null)
        {
            if(temp.val == 0)
            {
                c0++;
            }
            else if(temp.val == 1)
            {
                c1++;
            }
            else
            {
                c2++;
            }
            temp = temp.next;
        }
        Node h1;
        if(c0 != 0)
        {
            h1 = new Node(0);
            c0--;
        }
        else if(c1 != 0)
        {
            h1 = new Node(1);
            c1--;
        }
        else
        {
            h1 = new Node(2);
            c2--;
        }

        Node t = h1;
        while(c0 > 0)
        {
            t.next = new Node(0);
            t = t.next;
            c0--;
        }
        while(c1 > 0)
        {
            t.next = new Node(1);
            t = t.next;
            c1--;
        }
        while(c2 > 0)
        {
            t.next = new Node(2);
            t = t.next;
            c2--;
        }

    return h1;


    }

    public static void main(String args[])
    {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(0);

        Node h1 = sort(head);
        Node t = h1;
        while(t != null)
        {
            System.out.print(t.val+" ");
            t = t.next;
        }
        System.out.println();
    }
}