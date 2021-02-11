import java.util.Stack;

public class RStack {
    static RStack rajendra = new RStack();

    public static void main(String[] args) {
        boolean isDuplicateBracket = rajendra.duplicate("(a + b) + ((c + d))");
        System.out.println("Does Duplicate exist " + isDuplicateBracket);
    }

    private boolean duplicate(String query) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < query.length(); i++) {

            char ch = query.charAt(i);
//            check if the  current element in stack and ch are same than duplicate exist
            if (!s.isEmpty() && ch == s.peek()) {
                return true;
            }
//            it is use to balance the stack
            if (ch == '(') {
                s.push(ch);
            }
            if (ch == ')') {
                s.pop();
            }

        }
        return false;
    }
}
