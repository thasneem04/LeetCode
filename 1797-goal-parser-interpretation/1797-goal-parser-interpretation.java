class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                st.push(ch);
            } else if (ch == ')' && st.peek() == '(') {
                st.pop();
                st.push('o');
            } else if (ch == ')' && st.peek() == 'l') {
                st.pop();
                st.pop();
                st.pop();
                st.push('a'); 
                st.push('l');
            } else {
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}