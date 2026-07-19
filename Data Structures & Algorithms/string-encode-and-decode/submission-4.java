class Solution {
    // ok so this is intresting, we can do like Huffman encoding if the regular join, split doesn't work?
    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs) {
            result += s.length() + "#" + s;  
        }
        return result;

    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i = 0;
        // "6#robert7#dominik"
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int num = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + num));
            i = j + 1 + num;
        }
        return result;
    }
}
