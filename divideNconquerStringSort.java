public abstract class divideNconquerStringSort {
    public static void mergeSort(String[] arr, int left, int right) {
        
    }
    public static void main (String args[]) {
        String [] arr = {"q", "p", "r", "b", "a", "c"};
        mergeSort(arr, 0, arr.length-1);

        for(int idx = 0; idx<arr.length; idx++) {
            System.out.print(arr[idx] + " ");
        }
    }
}
