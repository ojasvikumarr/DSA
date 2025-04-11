package CDLab;

import java.util.*;

public class FirstFollow {
    static Map<String, List<String>> grammar = new HashMap<>();
    static Map<String, Set<String>> first = new HashMap<>();
    static Map<String, Set<String>> follow = new HashMap<>();
    static String startSymbol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of productions: ");
        int n = sc.nextInt(); sc.nextLine();

        System.out.println("Enter productions (e.g., E->TR|ε): ");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("->");
            String lhs = parts[0].trim();
            String[] rhs = parts[1].split("\\|");

            grammar.putIfAbsent(lhs, new ArrayList<>());
            for (String prod : rhs)
                grammar.get(lhs).add(prod.trim());

            if (i == 0) startSymbol = lhs; // first is start symbol
        }

        // Compute FIRST sets
        for (String nonTerm : grammar.keySet()) {
            computeFirst(nonTerm);
        }

        // Initialize FOLLOW sets
        for (String nonTerm : grammar.keySet()) {
            follow.put(nonTerm, new HashSet<>());
        }
        follow.get(startSymbol).add("$"); // $ is end marker

        // Compute FOLLOW sets
        for (String nonTerm : grammar.keySet()) {
            computeFollow(nonTerm);
        }

        // Display FIRST
        System.out.println("\nFIRST sets:");
        for (String nonTerm : first.keySet()) {
            System.out.println("FIRST(" + nonTerm + ") = " + first.get(nonTerm));
        }

        // Display FOLLOW
        System.out.println("\nFOLLOW sets:");
        for (String nonTerm : follow.keySet()) {
            System.out.println("FOLLOW(" + nonTerm + ") = " + follow.get(nonTerm));
        }
        sc.close();
    }

    static Set<String> computeFirst(String symbol) {
        if (first.containsKey(symbol)) return first.get(symbol);

        Set<String> result = new HashSet<>();
        first.put(symbol, result);

        if (!grammar.containsKey(symbol)) {
            result.add(symbol); // terminal
            return result;
        }

        for (String production : grammar.get(symbol)) {
            if (production.equals("ε")) {
                result.add("ε");
                continue;
            }

            for (int i = 0; i < production.length(); i++) {
                String ch = String.valueOf(production.charAt(i));
                Set<String> firstSet = computeFirst(ch);
                result.addAll(firstSet);
                result.remove("ε");

                if (!firstSet.contains("ε"))
                    break;
                if (i == production.length() - 1)
                    result.add("ε");
            }
        }

        return result;
    }

    static void computeFollow(String nonTerm) {
        for (String lhs : grammar.keySet()) {
            for (String prod : grammar.get(lhs)) {
                for (int i = 0; i < prod.length(); i++) {
                    if (String.valueOf(prod.charAt(i)).equals(nonTerm)) {
                        if (i + 1 < prod.length()) {
                            String next = String.valueOf(prod.charAt(i + 1));
                            Set<String> nextFirst = computeFirst(next);
                            follow.get(nonTerm).addAll(nextFirst);
                            follow.get(nonTerm).remove("ε");

                            if (nextFirst.contains("ε"))
                                follow.get(nonTerm).addAll(follow.get(lhs));
                        } else {
                            if (!nonTerm.equals(lhs))
                                follow.get(nonTerm).addAll(follow.get(lhs));
                        }
                    }
                }
            }
        }
    }
}