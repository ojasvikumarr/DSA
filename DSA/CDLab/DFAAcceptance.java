package CDLab;

import java.util.*;

public class DFAAcceptance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define DFA
        int startState = 0;
        Set<Integer> finalStates = new HashSet<>(Arrays.asList(2));

        // DFA transitions: Map<currentState, Map<inputChar, nextState>>
        Map<Integer, Map<Character, Integer>> transitions = new HashMap<>();

        // Add transitions
        addTransition(transitions, 0, 'a', 1);
        addTransition(transitions, 1, 'b', 2);
        addTransition(transitions, 2, 'a', 2); // loop

        // Input string
        System.out.print("Enter input string: ");
        String input = sc.next();

        int currentState = startState;

        for (char ch : input.toCharArray()) {
            if (!transitions.containsKey(currentState) || !transitions.get(currentState).containsKey(ch)) {
                System.out.println("Rejected");
                return;
            }
            currentState = transitions.get(currentState).get(ch);
        }
        
        if (finalStates.contains(currentState)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }
        sc.close();
    }

    static void addTransition(Map<Integer, Map<Character, Integer>> map, int from, char symbol, int to) {
        map.putIfAbsent(from, new HashMap<>());
        map.get(from).put(symbol, to);
    }
}
