class Solution {
    public boolean isAnagram(String s, String t) {
        // two hashmaps compare their contents?
        // or even better for s we add value to the key and for t we subtract than if the hashmap is = 0 sum it's valid anagram
        // sort the string nlogn + loop through and see if it matches so 2nlogn + n.
        if(s.length() != t.length()){
            return false;
        }
        Map<String, Integer> anagramVal = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            anagramVal.merge(s.substring(i, i+1), 1, Integer::sum);
            anagramVal.merge(t.substring(i, i+1), -1, Integer::sum);
        }

        boolean anagram = anagramVal.values().stream().allMatch(value -> value == 0);

        return anagram;
    }
}
