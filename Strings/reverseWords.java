class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        String S[] = str.split("\\s+");
        String res = "";

        for(int i = S.length-1 ; i > 0 ; i--)
        {
            res += S[i]+" ";
        }
        res += S[0];
        return res;
    }
}