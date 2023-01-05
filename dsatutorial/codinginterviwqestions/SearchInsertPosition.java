package dsatutorial.codinginterviwqestions;

// LeetCode #35
public class SearchInsertPosition {

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7}; // needs to be sorted in ascending order for binary search to work
        int searchFor = 2;
        System.out.println(search(arr, searchFor));
    }

}
