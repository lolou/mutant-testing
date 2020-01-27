package demo.text.analysis;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBracketsValidator {

    private static final Map<Character, Character> PAIRS = Map.of(']', '[',
                                                                  ')', '(',
                                                                  '}' ,'{');
    public static final Set<Character> CLOSINGS = PAIRS.keySet();
    public static final Collection<Character> OPENINGS = PAIRS.values();


    public boolean isBalanced(final String expression) {
        final Stack<Character> stack = new Stack<>();

        for (int index = 0; index < expression.length(); index++) {
            final char bracket = expression.charAt(index);
            if (isOpeningBracket(bracket)) {
                stack.push(bracket);
            } else if (isClosingBracket(bracket)) {
                final Character openingBracket = stack.pop();
                if (areUnmatchablePair(openingBracket, bracket)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean areUnmatchablePair(final Character openingBracket, final char bracket) {
        return !PAIRS.get(bracket).equals(openingBracket);
    }

    private boolean isClosingBracket(final char bracket) {
        return CLOSINGS.contains(bracket);
    }

    private boolean isOpeningBracket(final char bracket) {
        return OPENINGS.contains(bracket);
    }
}
