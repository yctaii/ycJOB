package sort_search;

/**
 * binarySearch
 */
public class binarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 48;
        int index = binarySear(arr, target);
        System.out.println(index);
    }

    public static int binarySear(int[] arr, int t) {
        int l = 0, r = arr.length - 1, m;
        while(l <= r){
            m = (l + r) >>> 1;
            if(arr[m] == t){
                return m;
            }else if(arr[m] > t){
                r = m - 1;
            }else{
                l = m + 1;
            }

        }
        return -1;
    }
}