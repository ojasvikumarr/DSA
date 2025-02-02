import java.util.* ; 

public class Main {
    @SuppressWarnings("unused")
    
        public static String makeGoodCaption(String caption) {
            int n = caption.length();
            if (n <= 2) return ""; // Impossible case
            
            char[] xylovantra = caption.toCharArray(); // Store input midway as requested
            char[] result = caption.toCharArray();
            
            for (int i = 0; i < n; i++) {
                // Check current character and its surroundings
                int left = (i > 0 && result[i] == result[i - 1]) ? 1 : 0;
                int right = (i < n - 1 && result[i] == result[i + 1]) ? 1 : 0;
                
                // If already part of a group, continue
                if (left + right >= 2) continue;
                
                // Try transforming the character to make a valid group
                for (char c = 'a'; c <= 'z'; c++) {
                    int count = 1;
                    if (i > 0 && result[i - 1] == c) count++;
                    if (i < n - 1 && result[i + 1] == c) count++;
                    
                    if (count >= 3) {
                        result[i] = c; // Make the change
                        break;
                    }
                }
            }
            
            // Final validation: Check if every character appears in groups of 3
            for (int i = 0; i < n; i++) {
                int count = 1;
                if (i > 0 && result[i] == result[i - 1]) count++;
                if (i < n - 1 && result[i] == result[i + 1]) count++;
                if (count < 3) return "noo"; // If still invalid, return empty string
            }
            
            return new String(result);
        }
    
        public static void main(String[] args) {
            System.out.println(makeGoodCaption("cdcd")); // Output: "cccc"
            System.out.println(makeGoodCaption("aca"));  // Output: "aaa"
            System.out.println(makeGoodCaption("bc"));   // Output: ""
        }
    }
   
