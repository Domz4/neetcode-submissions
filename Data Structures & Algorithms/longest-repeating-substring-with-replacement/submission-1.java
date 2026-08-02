class Solution {
    public int characterReplacement(String s, int k) {

        int[] maxf = new int[26];

        // so this becomes table of frequencies for a string AAABBA is 
        // [4, 2, 0, 0 ...];

        int left = 0;
        int max = k;


        for(int right=0; right<s.length(); right++) {
            maxf[s.charAt(right) - 'A']++;
            int validity = (right - left + 1) - mostFrequent(maxf);
            
            
            if (validity > k) {
                // invalid shring window
                // remove character from the maxf table
                maxf[s.charAt(left) - 'A']--; 
                left++;

            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }

    int mostFrequent(int[] maxf) {
        int max = 0;
        for (int count : maxf) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    } 
}
