package demo.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SpanishPersonDocumentValidatorTest {

    final SpanishPersonDocumentValidator validator = new SpanishPersonDocumentValidator();

    @Test
    void testDNICitizenJuanCarlosDeBourbon() {
        assertTrue(validator.isValid("3A"));
    }

    @Test
    void testDNIFirstInmigrant() {
        assertTrue(validator.isValid("X0000001R"));
    }

}