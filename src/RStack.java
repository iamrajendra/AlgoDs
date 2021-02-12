import java.util.Stack;

public class RStack {
    static RStack rajendra = new RStack();

    public static void main(String[] args) {
        boolean isDuplicateBracket = rajendra.duplicate("(a + b) + ((c + d))");
        System.out.println("Does Duplicate exist " + isDuplicateBracket);
        boolean bal = rajendra.balanceBracket("[(a + b) + {(c + d) * (e / f)}]");
        System.out.println("Is bracket is balance " + bal);
        int[] input = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        printArray(rajendra.nextGreaterElementByStack(input));

    }


    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private int[] nextGreaterElementByStack(int[] input) {
        //  {2, 5, 9, 3, 1, 12, 6, 8, 7}
        int[] nextGreater = new int[input.length]; // create the array equal length of input array
        Stack<Integer> s = new Stack<>();
        s.push(input[input.length - 1]);  // push the first element to compare with preceding element.
        nextGreater[input.length - 1] = -1; //  next greater of right is always -1
        for (int i = input.length - 2; i >= 0; i--) { // start the iteration from second last,
// because we have to compare from  last and second last.
//   pop all the element from the stack, who next greater is not possible
            while (!s.isEmpty() && input[i] > s.peek()) {
                s.pop();
            }
            if (s.isEmpty())
                nextGreater[i] = -1; // if the stack is empty than the next greater of element is not possible
            else // stack  current element is next greater element
                nextGreater[i] = s.peek();
            s.push(input[i]);
        }
        return nextGreater;
    }

    private boolean balanceBracket(String query) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                return handleBracket(s, '(');
            } else if (ch == '[') {
                return handleBracket(s, ']');
            } else if (ch == '{') {
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
