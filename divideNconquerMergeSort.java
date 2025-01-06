public class divideNconquerMergeSort {
    public static void mergeSort(String arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2; // also do (si+ei)/2
        mergeSort(arr, si, mid); // left part call
        mergeSort(arr, mid + 1, ei); // right part call
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr[]

        while (i <= mid && j <= ei) {
            if (smaller(arr[i], arr[j]) == true) { // left part element < right part element
                temp[k] = arr[i]; // i value is used...look in regester for dry run
                i++;
            } else {
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
    }

    public static boolean smaller(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return true; 
            } else if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }
        if (a.length() < b.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void PrintArray(String array[]) {
        System.out.print("Array after sorting: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        String arr1[] = { "q", "p", "r", "b", "a", "c" };
        mergeSort(arr1, 0, arr1.length - 1);
        PrintArray(arr1);
        System.out.println();
        String arr2[] = { "sun", "earth", "mars", "mercury" };
        mergeSort(arr2, 0, arr2.length - 1);
        PrintArray(arr2);
    }
}