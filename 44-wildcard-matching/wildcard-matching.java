class Solution {
    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sPtr < s.length()) {
            // 1. If characters match or pattern has '?'
            if (pPtr < p.length() && (p.charAt(pPtr) == '?' || p.charAt(pPtr) == s.charAt(sPtr))) {
                sPtr++;
                pPtr++;
            } 
            // 2. If pattern has '*', record the position and try matching 0 characters first
            else if (pPtr < p.length() && p.charAt(pPtr) == '*') {
                starIdx = pPtr;
                sTmpIdx = sPtr;
                pPtr++;
            } 
            // 3. If mismatch, but we encountered a '*' earlier, backtrack
            else if (starIdx != -1) {
                pPtr = starIdx + 1;
                sTmpIdx++;
                sPtr = sTmpIdx;
            } 
            // 4. Current characters don't match and no '*' to backtrack to
            else {
                return false;
            }
        }

        // 5. Check for remaining characters in pattern; they must all be '*'
        while (pPtr < p.length() && p.charAt(pPtr) == '*') {
            pPtr++;
        }

        return pPtr == p.length();
    }
}