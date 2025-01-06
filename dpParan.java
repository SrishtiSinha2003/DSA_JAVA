import java.util.ArrayList;
import java.util.List;

public class dpParan {

    // Function to generate all valid parentheses combinations for n pairs
    public List<String> generateParenthesis(int n) {
        // dp array to store results for 0 to n pairs
        List<List<String>> dp = new ArrayList<>();
        
        // Base case: when n = 0, there's only an empty string
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        // Build dp for all values from 1 to n
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            
            // Try all combinations for j pairs inside and (i-j-1) pairs outside
            for (int j = 0; j < i; j++) {
                for (String inside : dp.get(j)) {
                    for (String outside : dp.get(i - j - 1)) {
                        current.add("(" + inside + ")" + outside);
                    }
                }
            }
            dp.add(current);  // Store results for i pairs
        }

        return dp.get(n);
    }

    public static void main(String[] args) {
        dpParan bp = new dpParan();
        int n = 3;  // Example input for n pairs
        List<String> result = bp.generateParenthesis(n);
        
        // Print all valid parentheses combinations
        for (String s : result) {
            System.out.println(s);
        }
    }
}

