public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0, currLen = 0, start = 0; 
        int charCount; 
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                while(s.charAt(start) != s.charAt(i)){
                    map.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                map.put(s.charAt(i), 1); 
                maxLen = Math.max(i-start+1, maxLen);
            }
        }
        
        return maxLen; 
    }
}