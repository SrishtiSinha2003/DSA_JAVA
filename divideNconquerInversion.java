public class divideNconquerInversion {
    public static int mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return 0;
        }
        // kaam
        int ans = 0; // count the pairs from each sub array
        int mid = si + (ei - si) / 2; // also do (si+ei)/2
        ans += mergeSort(arr, si, mid); // left part call
        ans += mergeSort(arr, mid + 1, ei); // right part call
        ans += merge(arr, si, mid, ei);

        return ans;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int pairs = 0; // count the pairs and sent to mergeSort function
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr[]

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) { // left part element < right part element
                temp[k] = arr[i]; // i value is used...look in regester for dry run
                i++;
            } else { // we will count pairs in this cuz , (1st element > 2nd element)
                pairs += (mid - i + 1);
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left over part --- left array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // left over part --- right array
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original arr.
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
        return pairs;
    }

    public static void PrintArray(int array[]) {
        System.out.print("Array after sorting: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 4, 1, 3, 5 };
        int ans = mergeSort(arr, 0, arr.length - 1);
        PrintArray(arr);
        System.out.println("total no. of inversion pairs: " + ans);

    }
}