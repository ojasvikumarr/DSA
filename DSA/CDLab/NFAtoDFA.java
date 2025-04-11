package CDLab;
import java.util.*;

public class NFAtoDFA {
    static class NFA {
        Map<Integer, Map<Character, Set<Integer>>> transitions = new HashMap<>();
        Set<Integer> states = new HashSet<>();
        Set<Integer> finalStates = new HashSet<>();
        int startState;

        void addTransition(int from, char symbol, int to) {
            transitions.putIfAbsent(from, new HashMap<>());
            transitions.get(from).putIfAbsent(symbol, new HashSet<>());
            transitions.get(from).get(symbol).add(to);
        }
    }

    static class DFA {
        Map<Set<Integer>, Map<Character, Set<Integer>>> transitions = new HashMap<>();
        Set<Set<Integer>> finalStates = new HashSet<>();
        Set<Integer> nfaFinalStates;
    }

    public static DFA convertNFAtoDFA(NFA nfa, Set<Character> alphabet) {
        DFA dfa = new DFA();
        dfa.nfaFinalStates = nfa.finalStates;

        Queue<Set<Integer>> queue = new LinkedList<>();
        Set<Set<Integer>> visited = new HashSet<>();

        Set<Integer> start = new HashSet<>();
        start.add(nfa.startState);

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Set<Integer> current = queue.poll();
            dfa.transitions.putIfAbsent(current, new HashMap<>());

            for (char symbol : alphabet) {
                Set<Integer> next = new HashSet<>();
                for (int state : current) {
                    if (nfa.transitions.containsKey(state)) {
                        next.addAll(nfa.transitions.get(state).getOrDefault(symbol, new HashSet<>()));
                    }
                }
                if (!next.isEmpty()) {
                    dfa.transitions.get(current).put(symbol, next);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        // Identify DFA final states
        for (Set<Integer> dfaState : visited) {
            for (int s : dfaState) {
                if (nfa.finalStates.contains(s)) {
                    dfa.finalStates.add(dfaState);
                    break;
                }
            }
        }

        return dfa;
    }

    public static void main(String[] args) {
        NFA nfa = new NFA();
        nfa.startState = 0;
        nfa.states.addAll(Arrays.asList(0, 1, 2));
        nfa.finalStates.add(2);

        // NFA transitions
        nfa.addTransition(0, 'a', 0);
        nfa.addTransition(0, 'a', 1);
        nfa.addTransition(1, 'b', 2);

        Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b'));

        DFA dfa = convertNFAtoDFA(nfa, alphabet);

        System.out.println("DFA Transitions:");
        for (Set<Integer> state : dfa.transitions.keySet()) {
            for (char symbol : dfa.transitions.get(state).keySet()) {
                System.out.println(state + " -- " + symbol + " --> " + dfa.transitions.get(state).get(symbol));
            }
        }

        System.out.println("DFA Final States: " + dfa.finalStates);
    }
}