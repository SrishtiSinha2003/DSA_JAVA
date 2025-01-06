public class recursionOccurence {
    public static int firstOcc(int arr[], int key, int i) {
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOcc(arr, key, i+1);
    }
    public static void main (String args[]) {
        int arr[] = {5,7,2,8,3,6,2,5,8};
        System.out.println(firstOcc(arr, 6, 0));
    }
}
