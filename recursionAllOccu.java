public class recursionAllOccu {
    public static void allOcc(int arr[], int key, int i) {
        if(i == arr.length) {
            return;
        }
        if(arr[i] == key) {
            System.out.print(i+" ");
        }
        allOcc(arr, key, i+1);
    }
    public static void main(String args[]) {
        int arr[] = {3, 4, 2, 8, 7, 9, 2, 6, 2};
        int key = 2;
        allOcc(arr, key, 0);
        System.out.println();
    }
}
