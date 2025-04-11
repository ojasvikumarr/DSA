package CDLab;

import java.util.*;

public class LeftFactoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of productions: ");
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> grammar = new HashMap<>();

        System.out.println("Enter productions in the form A->alpha:");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("->");
            String lhs = parts[0].trim();
            String rhs = parts[1].trim();
            grammar.putIfAbsent(lhs, new ArrayList<>());
            grammar.get(lhs).addAll(Arrays.asList(rhs.split("\\|")));
        }

        System.out.println("\nLeft Factored Grammar:");

        for (String nonTerminal : grammar.keySet()) {
            List<String> prods = grammar.get(nonTerminal);
            Map<String, List<String>> prefixMap = new HashMap<>();

            for (String prod : prods) {
                String prefix = prod.length() > 0 ? prod.substring(0, 1) : "";
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(prod);
            }

            boolean factored = false;
            for (String prefix : prefixMap.keySet()) {
                List<String> group = prefixMap.get(prefix);
                if (group.size() > 1) {
                    factored = true;
                    String newNonTerminal = nonTerminal + "'";
                    System.out.print(nonTerminal + " -> " + prefix + newNonTerminal + "\n");
                    System.out.print(newNonTerminal + " -> ");
                    List<String> tails = new ArrayList<>();
                    for (String g : group) {
                        tails.add(g.length() > 1 ? g.substring(1) : "ε");
                    }
                    System.out.println(String.join(" | ", tails));
                    break;
                }
            }

            if (!factored) {
                System.out.println(nonTerminal + " -> " + String.join(" | ", prods));
            }
        }
        sc.close();
    }
}