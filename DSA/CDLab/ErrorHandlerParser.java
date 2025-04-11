package CDLab ; 
import java.util.*;
import java.util.Arrays ; 

public class ErrorHandlerParser {
    static Set<String> syncTokens = new HashSet<>(Arrays.asList(";", "}"));
    static List<String> tokens;
    static int index = 0;

    public static void main(String[] args) {
        // Sample token stream (simulate from lexer)
        tokens = Arrays.asList("int", "a", "=", "5", ";", "if", "(", "a", ">", "3", ")", "{", "a", "=", "a", "+", ";", "}");
        System.out.println("Parsing with Error Handler...\n");

        while (index < tokens.size()) {
            parseStatement();
        }
    }

    static void parseStatement() {
        try {
            String token = getNext();
            if (token.equals("int")) {
                parseDeclaration();
            } else if (token.equals("if")) {
                parseIf();
            } else {
                throw new RuntimeException("Unexpected token: " + token);
            }
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            panicRecover();
        }
    }

    static void parseDeclaration() {
        String id = getNext();
        if (!isIdentifier(id)) throw new RuntimeException("Expected identifier, found: " + id);

        String eq = getNext();
        if (!eq.equals("=")) throw new RuntimeException("Expected '=', found: " + eq);

        String value = getNext();
        if (!isNumber(value)) throw new RuntimeException("Expected number, found: " + value);

        String semi = getNext();
        if (!semi.equals(";")) throw new RuntimeException("Expected ';', found: " + semi);

        System.out.println("[OK] Parsed declaration");
    }

    static void parseIf() {
        String open = getNext();
        if (!open.equals("(")) throw new RuntimeException("Expected '(', found: " + open);

        getNext(); // condition
        getNext(); // operator
        getNext(); // value

        String close = getNext();
        if (!close.equals(")")) throw new RuntimeException("Expected ')', found: " + close);

        String openBrace = getNext();
        if (!openBrace.equals("{")) throw new RuntimeException("Expected '{', found: " + openBrace);

        while (index < tokens.size() && !tokens.get(index).equals("}")) {
            parseStatement();
        }

        String closeBrace = getNext();
        if (!closeBrace.equals("}")) throw new RuntimeException("Expected '}', found: " + closeBrace);

        System.out.println("[OK] Parsed if-statement");
    }

    static void panicRecover() {
        System.out.println("[Recovery] Skipping tokens...");
        while (index < tokens.size() && !syncTokens.contains(tokens.get(index))) {
            index++;
        }
        if (index < tokens.size()) {
            System.out.println("[Recovery] Resuming at token: " + tokens.get(index));
            index++; // skip sync token
        }
    }

    static String getNext() {
        if (index >= tokens.size()) throw new RuntimeException("Unexpected end of input");
        return tokens.get(index++);
    }

    static boolean isIdentifier(String s) {
        return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    static boolean isNumber(String s) {
        return s.matches("\\d+");
    }
}