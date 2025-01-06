public class recursionLastOcc {
    public static int lastOcc(int arr[], int key, int i) {
        if(i== arr.length) {
            return -1;
        }
       int isFound = lastOcc(arr, key, i+1);
       if(isFound == -1 && arr[i] == key) {
        return i;
       }
       return isFound;
    }
    public static void main (String args[]) {
        int arr[] = {3,5,7,2,79,2,68,25,89,3,6,7};
        System.out.println(lastOcc(arr, 7, 0));
    }
}
