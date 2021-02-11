import java.util.Stack;

public class RStack {
    static RStack rajendra = new RStack();

    public static void main(String[] args) {
        boolean isDuplicateBracket = rajendra.duplicate("(a + b) + ((c + d))");
        System.out.println("Does Duplicate exist " + isDuplicateBracket);
        boolean bal = rajendra.balanceBracket("[(a + b) + {(c + d) * (e / f)}]");
        System.out.println("Is bracket is balance " + bal);
    }

    private boolean balanceBracket(String query) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                return handleBracket(s, '(');
            }
            else if (ch == '[') {
                return handleBracket(s, ']');
            }
            else if (ch == '{') {
                return handleBracket(s, '}');
            }

        }
        return false;
    }

    private boolean handleBracket(Stack<Character> s, char ch) {
        if (s.isEmpty()) {
            return false;
        } else if (s.peek() != ch) {
            return false;
        } else {
            s.pop();
            return true;
        }


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
