import java.util.Stack;

public class BracketBalance {

    public static void main(String[] args) {
        String input = "( [ [ { } ] ] )";

        if (isBalanced(input))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println(" The entered Strings do not contain Balanced Brackets");
    }

    static boolean isBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }

            if (stack.isEmpty())
                return false;

            char compare;
            switch (character) {
                case ')':
                    compare = stack.pop();
                    if (compare == '{' || compare == '[')
                        return false;
                    break;

                case '}':
                    compare = stack.pop();
                    if (compare == '(' || compare == '[')
                        return false;
                    break;

                case ']':
                    compare = stack.pop();
                    if (compare == '(' || compare == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}

