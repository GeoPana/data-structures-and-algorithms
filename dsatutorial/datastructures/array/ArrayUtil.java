package dsatutorial.datastructures.array;

public class ArrayUtil {

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");;
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5];
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 8;
        myArray[3] = 4;
        myArray[4] = 7;
        printArray(myArray);
        System.out.println("Length: " + myArray.length);
        System.out.println();
    }

    public static int[] removeEvenNumbers(int[] arr) {
        int newLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1)
                newLength++;
        }

        int[] newArray = new int[newLength];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    public static int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Invalid input. ");
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Invalid input. ");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

//    public static int findSecondMax(int[] arr) {
//        if (arr == null || arr.length == 0)
//        throw new IllegalArgumentException("Invalid input. ");
//
//        int max = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max)
//                max = arr[i];
//        }
//        int secondMax = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > secondMax && arr[i] < max)
//                secondMax = arr[i];
//        }
//        return secondMax;
//    }

    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    //#LeetCode283
    public static void moveZerosToEnd(int[] arr) {
        int j = 0; // focus on zero elements
        for (int i = 0; i < arr.length; i++) { // i focuses on non zero elements
            if (arr[i] !=0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0)
                j++;
        }
    }
//    public static void moveZerosToEnd(int[] arr) {
//        int end = arr.length -1;
//        int start = 0;
//        while (start <= end) {
//            int index = start;
//            if (arr[start] == 0) {
//                while (index + 1 < arr.length && arr[index + 1] == 0) {
//                    index++;
//                }
//                if (index + 1 < arr.length) {
//                    int temp = arr[start];
//                    arr[start] = arr[index + 1];
//                    arr[index + 1] = temp;
//                }
//                if (arr[end] == 0)
//                    end--;
//            }
//            start++;
//        }
//    }

    public static int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        return temp;
    }

    // sum of n natural elements = n x (n + 1) / 2
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int missingNumber = n * (n + 1) / 2;
        for (int i = 0; i < arr.length; i++){
            missingNumber -= arr[i];
        }
        return missingNumber;
    }

//    public static int findMissingNumber(int[] arr) {
//        for (int j = 1; j <= arr.length + 1; j++) {
//            boolean exists = false;
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] == j) {
//                    exists = true;
//                    break;
//                }
//            }
//            if (exists == false) {
//                return j;
//            }
//        }
//        return -1;
//    }



    public static void main(String[] args) {

        ArrayUtil arrUtil = new ArrayUtil();
        arrUtil.arrayDemo();

        int[] arr = {3, 2, 4, 7, 10, 6, 5};
        arrUtil.printArray(arr);
        int[] newArr = removeEvenNumbers(arr);
        printArray(newArr);
        reverseArray(arr);
        printArray(arr);
        System.out.println("Min: " + findMin(arr));
        System.out.println("Max: " + findMax(arr));
        System.out.println("Second Max: " + findSecondMax(arr));

//        int[] array = {0, 1, 0, 4, 12};
//        printArray(array);
//        moveZerosToEnd(array);
//        printArray(array);
//
//        int[] newArray = {1, 2, 3, 4};
//        printArray(newArray);
//        newArray = resize(newArray, 7);
//        printArray(newArray);
        int[] array = {2, 4, 1, 8, 6, 3, 7};
        printArray(array);
        int missingNumber = findMissingNumber(array);
        System.out.println("Missing Number: " + missingNumber);

    }

}
