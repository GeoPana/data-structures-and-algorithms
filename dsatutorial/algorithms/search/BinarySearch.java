package dsatutorial.algorithms.search;

public class BinarySearch {

    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                high = mid - 1;
            if (arr[mid] < key) // else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4 , 7, 8 , 10, 11, 20, 24, 50, 100}; // needs to be sorted in ascending order for binary search to work
        int searchFor = 7;
        int indexFound = search(arr, searchFor);
        if (indexFound == -1)
            System.out.println("Element " + searchFor + " not found");
        else
            System.out.println("Element " + searchFor + " found at index " + indexFound);
    }

}
