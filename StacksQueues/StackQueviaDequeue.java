import java.util.*;
class StackQueviaDequeue
{
    static Deque<Integer> dq1 = new LinkedList<>();
    static Deque<Integer> dq2 = new LinkedList<>();

    static class Stk
    {
        void push(int data)
        {
            dq1.addFirst(data);
        }

        int pop()
        {
            return dq1.removeFirst();
        }

        int peek()
        {
            return dq1.getFirst();
        }

        boolean isEmpty()
        {
            return dq1.isEmpty();
        }

    }

    static class Que
    {
        void add(int data)
        {
            dq2.addFirst(data);
        }

        int remove()
        {
            return dq2.removeLast();
        }

        int peek()
        {
            return dq2.getLast();
        }

        boolean isEmpty()
        {
            return dq2.isEmpty();
        }

    }
    public static void main(String args[])
    {
        Stk s = new Stk();
        Que q = new Que();

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.peek());

    }
}