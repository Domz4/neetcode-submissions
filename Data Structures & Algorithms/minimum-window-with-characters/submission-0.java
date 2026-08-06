class Solution {
    public String minWindow(String s, String t) {
        int left=0, right=0;
        int validity = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> occur = new HashMap<>();


        for (char ct : t.toCharArray()) {
            occur.merge(ct, 1, Integer::sum); 
        }
        while (right < s.length()) {
            char sc = s.charAt(right);
            right++;

            if (occur.containsKey(sc)) {
                if (occur.get(sc) > 0) {
                    validity--;
                }
                occur.merge(sc,-1, Integer::sum);
            }

            while (validity == 0) {
                int currentLen = right - left;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    start = left;
                }

                char lc = s.charAt(left);
                if (occur.containsKey(lc)) {
                    occur.merge(lc, 1, Integer::sum);
                    if (occur.get(lc) > 0) {
                        validity++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);        
    }
}
