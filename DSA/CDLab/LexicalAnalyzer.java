package CDLab;

import java.util.*;


public class LexicalAnalyzer {

    // Define keyword list
    static final Set<String> keywords = new HashSet<>(Arrays.asList(
        "int", "float", "if", "else", "while", "for", "return", "class", "public", "static", "void", "new", "import", "double", "char", "boolean"
    ));

    // Define operators and separators
    static final Set<String> operators = new HashSet<>(Arrays.asList(
        "+", "-", "*", "/", "=", "==", "<", ">", "<=", ">=", "!=", "++", "--", "&&", "||"
    ));

    static final Set<String> separators = new HashSet<>(Arrays.asList(
        "(", ")", "{", "}", ";", ",", "[", "]"
    ));

    public static void main(String[] args) {
        String code = "public class Demo { int a = 10; float b = 5.5f; if (a > b) a = a + 1; }";

        System.out.println("Lexical Analysis Output:\n");

        StringTokenizer tokenizer = new StringTokenizer(code, " \t\n\r()+-*/=<>!&|{};[],", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (keywords.contains(token)) {
                System.out.println(token + " → Keyword");
            } else if (operators.contains(token)) {
                System.out.println(token + " → Operator");
            } else if (separators.contains(token)) {
                System.out.println(token + " → Separator");
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                System.out.println(token + " → Identifier");
            } else if (token.matches("[0-9]+(\\.[0-9]+)?f?")) {
                System.out.println(token + " → Number");
            } else {
                System.out.println(token + " → Unknown Token");
            }
        }
    }
}