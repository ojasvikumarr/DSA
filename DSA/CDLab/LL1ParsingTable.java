package CDLab;

import java.util.*;

public class LL1ParsingTable {
    static Map<String, List<String>> grammar = new HashMap<>();
    static Map<String, Set<String>> first = new HashMap<>();
    static Map<String, Set<String>> follow = new HashMap<>();
    static Map<String, Map<String, String>> parsingTable = new HashMap<>();
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

        for (String nt : grammar.keySet()) {
            computeFirst(nt);
        }

        for (String nt : grammar.keySet()) {
            follow.putIfAbsent(nt, new HashSet<>());
        }
        follow.get(startSymbol).add("$");

        for (String nt : grammar.keySet()) {
            computeFollow(nt);
        }

        constructParsingTable();

        System.out.println("\nLL(1) Parsing Table:");
        printParsingTable();
        sc.close();
    }

    static Set<String> computeFirst(String symbol) {
        if (first.containsKey(symbol)) return first.get(symbol);

        Set<String> result = new HashSet<>();
        first.put(symbol, result);

        if (!grammar.containsKey(symbol)) {
            result.add(symbol);
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
            parsingTable.putIfAbsent(A, new HashMap<>());
            for (String prod : grammar.get(A)) {
                Set<String> firstSet = getFirstOfString(prod);
                for (String terminal : firstSet) {
                    if (!terminal.equals("ε")) {
                        parsingTable.get(A).put(terminal, prod);
                    }
                }
                if (firstSet.contains("ε")) {
                    for (String b : follow.get(A)) {
                        parsingTable.get(A).put(b, prod);
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

    static void printParsingTable() {
        Set<String> terminals = new HashSet<>();
        for (Map<String, String> row : parsingTable.values())
            terminals.addAll(row.keySet());

        System.out.print(String.format("%-10s", ""));
        for (String t : terminals)
            System.out.print(String.format("%-10s", t));
        System.out.println();

        for (String nt : parsingTable.keySet()) {
            System.out.print(String.format("%-10s", nt));
            for (String t : terminals) {
                String prod = parsingTable.get(nt).get(t);
                if (prod != null)
                    System.out.print(String.format("%-10s", nt + "→" + prod));
                else
                    System.out.print(String.format("%-10s", ""));
            }
            System.out.println();
        }
    }
}