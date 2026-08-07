class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            
            switch (sc) {
                case '{':
                case '[':
                case '(':
                    stack.push(sc);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
            }
        }
        
        // If the stack is empty, all opening brackets were matched!
        return stack.isEmpty(); 
    }
}