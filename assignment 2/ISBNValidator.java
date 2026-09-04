public class ISBNValidator {

    public static String normalizeCode(String raw) {

        raw = raw.trim();

        String firstThree = raw.substring(0, 3).toUpperCase();

        String remaining = raw.substring(3);

        return firstThree + remaining;
    }


    public static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }


        // Check first 3 characters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }


        // Check remaining 10 characters
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }


        // Get different parts
        String publisherCode = code.substring(0, 3);

        String year = code.substring(3, 7);

        String catalog = code.substring(7, 13);


        // Build final result
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String normalized = normalizeCode(raw);

        System.out.println(
                validateAndFormat(normalized)
        );


        String raw2 = "12N2026004251";

        // This example is directly tested
        System.out.println(
                validateAndFormat(raw2)
        );
    }
}