package CDLab;

import java.util.*;

public class LeftRecursionEliminator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of productions: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter production (e.g., A->Aa|b): ");
            String input = sc.nextLine();
            String[] parts = input.split("->");
            String nonTerminal = parts[0].trim();
            String[] productions = parts[1].split("\\|");

            List<String> alpha = new ArrayList<>(); // left recursive part
            List<String> beta = new ArrayList<>();  // non-left-recursive part

            for (String prod : productions) {
                prod = prod.trim();
                if (prod.startsWith(nonTerminal)) {
                    alpha.add(prod.substring(nonTerminal.length())); // remove A
                } else {
                    beta.add(prod);
                }
            }

            if (alpha.size() == 0) {
                // No left recursion
                System.out.println(nonTerminal + " -> " + String.join(" | ", productions));
            } else {
                String newNonTerminal = nonTerminal + "'";
                // A -> βA'
                System.out.print(nonTerminal + " -> ");
                List<String> newBeta = new ArrayList<>();
                for (String b : beta) {
                    newBeta.add(b + newNonTerminal);
                }
                System.out.println(String.join(" | ", newBeta));

                // A' -> αA' | ε
                System.out.print(newNonTerminal + " -> ");
                List<String> newAlpha = new ArrayList<>();
                for (String a : alpha) {
                    newAlpha.add(a + newNonTerminal);
                }
                newAlpha.add("ε");
                System.out.println(String.join(" | ", newAlpha));
            }
        }
        sc.close();
    }
}