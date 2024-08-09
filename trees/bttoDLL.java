class Solution
{
    Node prev = null;
    Node head;
    Node bToDLL(Node node)
    {
    	if (node == null) {
            return null;
        }

        bToDLL(node.left);

        if (prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        bToDLL(node.right);

        return head;
    }
}