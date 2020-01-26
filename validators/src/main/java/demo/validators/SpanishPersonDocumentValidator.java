package demo.validators;

import org.apache.commons.lang3.StringUtils;

/** based on algorithm available at
 * http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del-digito-de-control-del-nif-nie
 */
public class SpanishPersonDocumentValidator {

    public static final int STANDARD_DNI_SIZE = 8;
    private final String NIE_AUTHORIZED_BEGIN = "XYZ";
    private final String NIF_CONTROL_CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";

    /**
     * Get the control digit for a given nif (dni or nie)
     * @param nif without control digit
     * @return the control digit
     */
    public char getControlDigit(String nif) {
        nif = nif.toUpperCase();
        return isNIE(nif) ? calculateNIEControl(nif) : calculateDNIControl(nif);
    }

    /**
     * Verifies if a nif is valid
     * @param nif to be verified
     * @return true if the nif is valid, false otherwise
     */
    public boolean isValid(final String nif){
        final String nifWithoutDigit = nif.substring(0, nif.length() - 1);
        final String calculatedNIF = nifWithoutDigit + getControlDigit(nifWithoutDigit);
        return StringUtils.equals(nif, calculatedNIF);
    }

    private boolean isNIE(final String nif) {
        final String charControl = nif.substring(0, 1);
        return NIE_AUTHORIZED_BEGIN.contains(charControl);
    }

    private char calculateDNIControl(final String dni) {
        return calculateControlDigit(dni);
    }

    private char calculateNIEControl(final String nie) {
        final char firstLetter = nie.charAt(0);
        final int firstPositionValue = NIE_AUTHORIZED_BEGIN.indexOf(firstLetter);
        final String fullNIE = firstPositionValue + nie.substring(1);
        return calculateControlDigit(fullNIE);
    }

    private char calculateControlDigit(final String aux) {
        final int index = Integer.parseInt(aux) % 23;
        return NIF_CONTROL_CHARS.charAt(index);
    }
}