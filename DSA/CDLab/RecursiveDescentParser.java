package CDLab;

import java.util.*;

public class RecursiveDescentParser {
    static String input;
    static int index = 0;
    static char currentChar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        input = sc.nextLine().replaceAll(" ", "") + "$"; // Add end symbol
        currentChar = input.charAt(index);

        if (E() && currentChar == '$') {
            System.out.println("String Accepted!");
        } else {
            System.out.println("String Rejected!");
        }
        sc.close();
    }

    // E → T E'
    static boolean E() {
        if (T()) {
            return EPrime();
        }
        return false;
    }

    // E' → + T E' | ε
    static boolean EPrime() {
        if (currentChar == '+') {
            match('+');
            if (T()) {
                return EPrime();
            }
            return false;
        }
        return true; // ε
    }

    // T → F T'
    static boolean T() {
        if (F()) {
            return TPrime();
        }
        return false;
    }

    // T' → * F T' | ε
    static boolean TPrime() {
        if (currentChar == '*') {
            match('*');
            if (F()) {
                return TPrime();
            }
            return false;
        }
        return true; // ε
    }

    // F → (E) | id
    static boolean F() {
        if (currentChar == '(') {
            match('(');
            if (E()) {
                if (currentChar == ')') {
                    match(')');
                    return true;
                }
            }
            return false;
        } else if (Character.isLetter(currentChar)) {
            match(currentChar); // id = any letter
            return true;
        }
        return false;
    }

    static void match(char expected) {
        if (currentChar == expected) {
            index++;
            currentChar = input.charAt(index);
        } else {
            System.out.println("Error: expected '" + expected + "' but found '" + currentChar + "'");
        }
    }
}