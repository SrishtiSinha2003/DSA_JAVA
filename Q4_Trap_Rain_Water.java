import java.util.Stack;

public class Q4_Trap_Rain_Water {

    public static int trapRainwater(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int waterTrapped = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                waterTrapped += distance * boundedHeight;
            }
            stack.push(i);
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int trappedWater = trapRainwater(height);
        System.out.println("Total trapped water: " + trappedWater);
    }
}
