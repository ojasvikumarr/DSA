package CDLab;

import java.util.*;

public class PredictiveParser {
    static Map<String, List<String>> grammar = new HashMap<>();
    static Map<String, Set<String>> first = new HashMap<>();
    static Map<String, Set<String>> follow = new HashMap<>();
    static Map<String, Map<String, String>> table = new HashMap<>();
    static String startSymbol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of productions: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter productions (e.g., E->TR|ε):");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("->");
            String lhs = parts[0].trim();
            String[] rhs = parts[1].split("\\|");

            grammar.putIfAbsent(lhs, new ArrayList<>());
            for (String prod : rhs)
                grammar.get(lhs).add(prod.trim());

            if (i == 0) startSymbol = lhs;
        }

        for (String nt : grammar.keySet()) computeFirst(nt);
        for (String nt : grammar.keySet()) follow.putIfAbsent(nt, new HashSet<>());
        follow.get(startSymbol).add("$");
        for (String nt : grammar.keySet()) computeFollow(nt);

        constructParsingTable();

        // Input string
        System.out.print("\nEnter input string (e.g., a+a): ");
        String input = sc.nextLine().replaceAll("\\s+", "") + "$";

        parseInput(input);
        sc.close();
    }

    // --- FIRST, FOLLOW, TABLE Construction ---
    static Set<String> computeFirst(String symbol) {
        if (first.containsKey(symbol)) return first.get(symbol);
        Set<String> result = new HashSet<>();
        first.put(symbol, result);

        if (!grammar.containsKey(symbol)) {
            result.add(symbol); // terminal
            return result;
        }

        for (String prod : grammar.get(symbol)) {
            if (prod.equals("ε")) {
                result.add("ε");
                continue;
            }
            for (int i = 0; i < prod.length(); i++) {
                String ch = String.valueOf(prod.charAt(i));
                Set<String> chFirst = computeFirst(ch);
                result.addAll(chFirst);
                result.remove("ε");
                if (!chFirst.contains("ε")) break;
                if (i == prod.length() - 1) result.add("ε");
            }
        }
        return result;
    }

    static void computeFollow(String nt) {
        for (String lhs : grammar.keySet()) {
            for (String prod : grammar.get(lhs)) {
                for (int i = 0; i < prod.length(); i++) {
                    String symbol = String.valueOf(prod.charAt(i));
                    if (symbol.equals(nt)) {
                        if (i + 1 < prod.length()) {
                            String next = String.valueOf(prod.charAt(i + 1));
                            Set<String> nextFirst = computeFirst(next);
                            follow.get(nt).addAll(nextFirst);
                            follow.get(nt).remove("ε");
                            if (nextFirst.contains("ε")) {
                                follow.get(nt).addAll(follow.get(lhs));
                            }
                        } else {
                            if (!nt.equals(lhs)) {
                                follow.get(nt).addAll(follow.get(lhs));
                            }
                        }
                    }
                }
            }
        }
    }

    static void constructParsingTable() {
        for (String A : grammar.keySet()) {
            table.putIfAbsent(A, new HashMap<>());
            for (String prod : grammar.get(A)) {
                Set<String> firstSet = getFirstOfString(prod);
                for (String terminal : firstSet) {
                    if (!terminal.equals("ε")) {
                        table.get(A).put(terminal, prod);
                    }
                }
                if (firstSet.contains("ε")) {
                    for (String b : follow.get(A)) {
                        table.get(A).put(b, prod);
                    }
                }
            }
        }
    }

    static Set<String> getFirstOfString(String str) {
        Set<String> result = new HashSet<>();
        if (str.equals("ε")) {
            result.add("ε");
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            Set<String> temp = computeFirst(ch);
            result.addAll(temp);
            result.remove("ε");
            if (!temp.contains("ε")) break;
            if (i == str.length() - 1) result.add("ε");
        }
        return result;
    }

    // --- Parsing Logic ---
    static void parseInput(String input) {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push(startSymbol);

        int index = 0;
        while (!stack.isEmpty()) {
            String top = stack.peek();
            String current = String.valueOf(input.charAt(index));

            if (top.equals(current)) {
                stack.pop();
                index++;
            } else if (!grammar.containsKey(top)) {
                System.out.println("Error: Unexpected symbol '" + current + "'");
                return;
            } else {
                String prod = table.getOrDefault(top, new HashMap<>()).get(current);
                if (prod == null) {
                    System.out.println("Error: No rule for [" + top + ", " + current + "]");
                    return;
                }

                System.out.println(top + " -> " + prod);
                stack.pop();
                if (!prod.equals("ε")) {
                    for (int i = prod.length() - 1; i >= 0; i--) {
                        stack.push(String.valueOf(prod.charAt(i)));
                    }
                }
            }
        }

        if (index == input.length()) {
            System.out.println("String Accepted!");
        } else {
            System.out.println("String Rejected!");
        }
    }
}
