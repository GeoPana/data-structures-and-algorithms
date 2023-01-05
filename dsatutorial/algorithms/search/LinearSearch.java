package dsatutorial.algorithms.search;

public class LinearSearch {

    public static int search(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4 , 7, 8 , 2, 11};
        int searchFor = 4;
        int indexFound = search(arr, arr.length, searchFor);
        if (indexFound == -1)
            System.out.println("Element " + searchFor + " not found");
        else
            System.out.println("Element " + searchFor + " found at index " + indexFound);
    }

}
