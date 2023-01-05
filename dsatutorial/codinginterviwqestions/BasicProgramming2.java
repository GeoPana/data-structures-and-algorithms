package dsatutorial.codinginterviwqestions;

import java.util.Scanner;

public class BasicProgramming2 {

    public static void basicProgramming(int N, int t, int[] A) {
        switch (t) {
            case 1:
                case1(A, N);
                break;
            case 2:
                case2(A, N);
                break;
            case 3:
                case3(A, N);
                break;
            case 4:
                case4(A, N);
                break;
            case 5:
                case5(A, N);
                break;
        }
    }
    public static void case1(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] + arr[j] == 7777 && arr[i] != arr[j])
                    System.out.println("\nYes ");
                return;
            }
        }
        System.out.println("\nNo ");
    }

    public static void case2(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] == arr[j])
                    System.out.println("\nContains duplicate ");
                return;
            }
        }
        System.out.println("\nUnique ");
    }

    public static void case3(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int timesOccurs = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    timesOccurs++;
                }
            }
            if (timesOccurs > N / 2) {
                System.out.println(arr[i] + " occurs " + timesOccurs +
                        " which is more than " + (N / 2) + " times");
                return;
            }
        }
        System.out.println(-1);
    }

    public static void case4(int[] arr, int N) {
        int[] sortedArr = bubbleSort(arr, N);
        if (N % 2 == 1) {
            System.out.println(sortedArr[N / 2]);
        } else {
            System.out.println(sortedArr[N / 2 - 1] + " " + sortedArr[N / 2]);
        }
    }

    public static void case5(int[] arr, int N) {
        int[] sortedArr = bubbleSort(arr, N);
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 100 && arr[i] <= 999)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] bubbleSort(int[] arr, int N) {
        int[] result = new int[arr.length];
        boolean isSwapped = false;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

    }
}
