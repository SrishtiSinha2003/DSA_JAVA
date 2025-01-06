public class divideNconquerMajority {

    public static int majority(int arr[], int si, int ei) {
        // base case
        if (si == ei) {
            return arr[si];
        }
        // kaam
        int mid = si + (ei - si) / 2;
        int ansA = majority(arr, si, mid);
        int ansB = majority(arr, mid + 1, ei);

        int countA = getCount(arr, si, mid, ansA);
        int countB = getCount(arr, mid + 1, ei, ansB);

        if (countA > countB) {
            return ansA;
        } else {
            return ansB;
        }
    }

    public static int getCount(int arr[], int si, int ei, int target) {
        int count = 0;
        for (int i = si; i < ei; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 20, 10, 20, 30, 30, 20, 20 };
        int ans = majority(arr, 0, arr.length - 1);
        System.err.println(ans);
    }
}
