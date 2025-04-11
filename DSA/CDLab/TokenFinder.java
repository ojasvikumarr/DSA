package CDLab;

import java.util.*;


public class TokenFinder {
    // Define Java keywords
    static final Set<String> keywords = new HashSet<>(Arrays.asList(
        "int", "float", "if", "else", "while", "for", "return", "class", "public", "static", "void", "new", "import"
    ));

    public static void main(String[] args) {
        String code = "public class Demo { int a = 5; float b = 2.5f; if (a > 0) a = a + 1; }";

        // Split using space, symbols, etc.
        StringTokenizer st = new StringTokenizer(code, " \t\n\r{}();=+-*/><!&|.,\"", true);

        Set<String> identifiers = new HashSet<>();
        Set<String> operators = new HashSet<>();
        Set<String> numbers = new HashSet<>();
        Set<String> keywordSet = new HashSet<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();
            if (token.isEmpty()) continue;

            if (keywords.contains(token)) {
                keywordSet.add(token);
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                identifiers.add(token);
            } else if (token.matches("[0-9]+(\\.[0-9]+)?f?")) {
                numbers.add(token);
            } else if ("=+-*/><!&|".contains(token)) {
                operators.add(token);
            }
        }

        // Display results
        System.out.println("Keywords: " + keywordSet);
        System.out.println("Identifiers: " + identifiers);
        System.out.println("Numbers: " + numbers);
        System.out.println("Operators: " + operators);
    }
}