import java.util.*;
public class stackStock {
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // span of day one is always 1
        s.push(0);  // push the index of span of day 1

        for(int i=1; i<stocks.length; i++) { // calculate span of each day
            int currPrice = stocks[i];   // current price of the stock at the index i
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {   // s.peek gives the index of the stock and fir stocks m daal k peek ka value uss din k stock ka value nikala and then compare with currPrice 
                // agr currPrice bada hoga then prevHigh same hoga nae to it will change
                s.pop();    // jab tak currPrice bada hoga tb tak indexes ko pop krna h
            }
            if(s.isEmpty()) {
                span[i] = i+1;   // agar stack empty ho jayega then prevHigh wahi elemnt hoga so uska index hoga i+1
            } else {
                int prevHigh = s.peek();  // s.peek k baad current jo highest value h uska index
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String args[]) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span); // function

        for(int i=0; i<span.length; i++) { // printing span
            System.out.println(span[i] + " ");
        }
    }
}
