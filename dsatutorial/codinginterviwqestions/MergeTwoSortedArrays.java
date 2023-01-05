package dsatutorial.codinginterviwqestions;

public class MergeTwoSortedArrays {

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            }else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 9, 10};
        printArray(arr1);
        int[] arr2 = {4, 6, 11, 15};
        printArray(arr2);
        int[] merged = mergeTwoSortedArrays(arr1, arr2);
        printArray(merged);
    }
}
