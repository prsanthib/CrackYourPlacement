class Solution {
    public int characterReplacement(String s, int k) {
         int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {

            char endChar = s.charAt(end);
            freq.put(endChar, freq.getOrDefault(endChar, 0) + 1);
            
            maxCount = Math.max(maxCount, freq.get(endChar));
            
            int windowSize = end - start + 1;
            int replacementsNeeded = windowSize - maxCount;
            
            if (replacementsNeeded > k) {
                char startChar = s.charAt(start);
                freq.put(startChar, freq.get(startChar) - 1);
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}