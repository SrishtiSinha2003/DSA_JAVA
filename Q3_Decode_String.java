import java.util.*;

// hard type code you can skip if cannot understand
public class Q3_Decode_String {

    public static String decodeString(String s) {
        // to store numbers
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);

        // to store strings
        Stack<StringBuilder> s2 = new Stack<>();
        s2.push(new StringBuilder()); // empty

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) { // if digit
                s1.push(s1.pop() * 10 + (ch - '0'));
            } else if (Character.isAlphabetic(ch)) { // if character
                s2.peek().append(ch);
            } else if (ch == '[') { // opening bracket
                s1.push(0);
                s2.push(new StringBuilder());
            } else if (ch == ']') {
                StringBuilder str = s2.pop();
                s1.pop();
                int count = s1.pop();
                while (count-- > 0) {
                    s2.peek().append(str);
                    s1.push(0);
                }
            }
        }
        return s2.peek().toString();
    }

    public static void main(String[] args) {
        String s = "4[a3[b]2[c1[d]]]";
        System.out.println(decodeString(s));
    }
}