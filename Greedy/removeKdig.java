class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)
        {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < num.length() ; i++)
        {
            while(k>0 && !stack.isEmpty()&& stack.peek() > num.charAt(i))
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while(!stack.isEmpty() && k > 0)
        {
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder("");
        while(!stack.isEmpty())
        {
            res.insert(0,stack.pop());
        }
         
        while(res.length()>0 && res.charAt(0) == '0')
        {
            res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}