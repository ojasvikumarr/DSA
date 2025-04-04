#include <iostream>
  #include <set>
  #include <map>
  #include <queue>
 
  using namespace std;
 
  class NFA {
  public:
      map<int, map<char, set<int>>> transition;
      int startState;
      set<int> acceptStates;
 
      void addTransition(int from, char symbol, int to) {
          transition[from][symbol].insert(to);
      }
  };
 
  class DFA {
  public:
      map<set<int>, map<char, set<int>>> transition;
      set<set<int>> acceptStates;
  };
 
  DFA convertNFAtoDFA(NFA nfa, set<int> states, set<char> alphabet) {
      DFA dfa;
      queue<set<int>> q;
      set<set<int>> dfaStates;
 
      q.push({nfa.startState});
      dfaStates.insert({nfa.startState});
 
      while (!q.empty()) {
          set<int> current = q.front();
          q.pop();
 
          for (char symbol : alphabet) {
              set<int> newState;
              for (int state : current) {
                  if (nfa.transition.count(state) && nfa.transition[state].count(symbol)) {
                      newState.insert(nfa.transition[state][symbol].begin(), nfa.transition[state][symbol].end());
                  }
              }
 
              if (!newState.empty() && dfaStates.find(newState) == dfaStates.end()) {
                  dfaStates.insert(newState);
                  q.push(newState);
              }
              dfa.transition[current][symbol] = newState;
          }
      }
 
      for (set<int> stateSet : dfaStates) {
          for (int state : stateSet) {
              if (nfa.acceptStates.count(state)) {
                  dfa.acceptStates.insert(stateSet);
                  break;
              }
          }
      }
 
      return dfa;
  }
 
  int main() {
      NFA nfa;
      set<int> states = {0, 1, 2};
      set<char> alphabet = {'a', 'b'};
     
      nfa.startState = 0;
      nfa.acceptStates = {2};
      nfa.addTransition(0, 'a', 0);
      nfa.addTransition(0, 'a', 1);
      nfa.addTransition(1, 'b', 2);
 
      DFA dfa = convertNFAtoDFA(nfa, states, alphabet);
 
      cout << "DFA Transitions:\n";
      for (map<set<int>, map<char, set<int>>>::iterator it = dfa.transition.begin(); it != dfa.transition.end(); ++it) {
          cout << "{ ";
          for (int x : it->first) cout << x << " ";
          cout << "} -> ";
          for (map<char, set<int>>::iterator jt = it->second.begin(); jt != it->second.end(); ++jt) {
              cout << jt->first << ": { ";
              for (int x : jt->second) cout << x << " ";
              cout << "} ";
          }
          cout << "\n";
      }
 
      return 0;
  }
