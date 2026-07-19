class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {

    //  // we can sort the words, 
    //  List<List<String>> anagrams = new ArrayList<>();

    //  if(strs.length != 0){
    //     anagrams.add(new ArrayList<>(List.of(strs[0])));
    //  }

    //  for(int i = 1; i<strs.length; i++) {

    //     boolean flag = true;

    //     for(int j = 0; j<anagrams.size(); j++) {
    //         if(helper(anagrams.get(j).get(0), strs[i])) {
    //             anagrams.get(j).add(strs[i]);
    //             flag = false;
    //             break;
    //         }
    //      }
    //     if (flag) {
    //         anagrams.add(new ArrayList<>(List.of(strs[i])));
    //     }
    //  }
    //  return anagrams;

    // }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public boolean helper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }

        return map.values().stream().allMatch(v -> v == 0);
    }
}
