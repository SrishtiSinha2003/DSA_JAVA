import java.util.*;

public class arrayListMostFre {

    public static int mostFrequency(ArrayList<Integer> list, int target) {
        // bulilding count index
        int count[] = new int[1001];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == target) {
                count[list.get(i)]++;
            }
        }

        // finding the index with greatest entry in count array
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of num: ");
        int n = sc.nextInt(); // size of array list

        // input elements
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        System.out.print("Enter target: ");
        int k = sc.nextInt(); // target
        sc.close();

        int ans = mostFrequency(list, k);
        System.out.println(ans);
    }
}