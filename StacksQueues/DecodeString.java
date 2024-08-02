class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder res = new StringBuilder("");
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == ']')
            {
                String str = "";
                while(stack.peek() != '[')
                {
                    str = stack.pop()+str;
                }
                stack.pop();
                int n = 0;
                int count = 0;
                int p = 0;

                while(!stack.isEmpty() && stack.peek()-'0' >= 0 && stack.peek()-'0' <= 9)
                {
                    n = ((stack.pop()-'0')*(int)Math.pow(10,p))+n;
                    p++;
                }

                StringBuilder temp = new StringBuilder("");  
                for(int k = 0 ; k < n ; k++)
                {
                    temp.append(str);
                }

                for(int j = 0 ; j < temp.length() ; j++)
                {
                    stack.push(temp.charAt(j));
                }
                
            } 
            else
            {
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty())
        {
            res.insert(0,stack.pop());
        }

        return res.toString();
    }
}