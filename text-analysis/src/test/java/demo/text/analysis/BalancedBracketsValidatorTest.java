package demo.text.analysis;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BalancedBracketsValidatorTest {

    private final BalancedBracketsValidator balancedBracketsValidator = new BalancedBracketsValidator();

    @Test
    void testBalancedParenthesis() {
        assertTrue(balancedBracketsValidator.isBalanced("()[]{[]}"));
    }

    @Test
    void testUnbalancedParenthesis() {
        assertFalse(balancedBracketsValidator.isBalanced("{[}]"));
    }
}