import java.util.Stack;

public class stackDecode {

    public static String decodeString(String s) {
        // Stacks to store counts and intermediate strings
        Stack<Integer> counts = new Stack<>();
        Stack<String> strings = new Stack<>();

        // StringBuilder to construct current string
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        // Iterate through the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) { // If character is a digit, update count
                count = count * 10 + (ch - '0');
            } else if (ch == '[') { // If character is an opening bracket, push count and current string to stacks,
                                    // reset count and current string
                counts.push(count);
                strings.push(currentString.toString());
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') { // If character is a closing bracket, pop count and previous string from stacks,
                                    // repeat current string count times and append to previous string
                int repeatCount = counts.pop();
                StringBuilder temp = new StringBuilder(strings.pop());
                for (int j = 0; j < repeatCount; j++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else { // If character is a letter, append to current string
                currentString.append(ch);
            }
        }
        return currentString.toString(); // Return the final decoded string
    }

    public static void main(String[] args) {
        String s = "4[a3[b]2[c1[d]]]";
        System.out.println(decodeString(s)); // Output: "abbbcdcddcddc"
    }
}