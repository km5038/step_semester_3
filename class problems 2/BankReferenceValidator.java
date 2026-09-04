public class BankReferenceValidator {

    public static String normalizeReference(String raw) {

        raw = raw.trim();

        String firstThree = raw.substring(0, 3).toUpperCase();

        String remaining = raw.substring(3);

        return firstThree + remaining;
    }


    public static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);

        String day = reference.substring(3, 5);

        String month = reference.substring(5, 7);

        String year = reference.substring(7, 9);

        String sequence = reference.substring(9, 14);


        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " hdf03022600042 ";

        String normalized = normalizeReference(raw);

        System.out.println(
            validateAndFormat(normalized)
        );


        String raw2 = "12F03022600042";

        String normalized2 = normalizeReference(raw2);

        System.out.println(
            validateAndFormat(normalized2)
        );
    }
}