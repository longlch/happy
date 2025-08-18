package w3school.array;

public class BubbleSort {
    public static void main(String[] args) {
        // Try 1: bubbleSortFirstTry
        /*int[] arr = {7, 12, 9, 11, 3};
        //int[] arr = {7, 9, 11, 3, 12};
        //int[] arr = {7, 9, 3, 11, 12};
        //int[] arr = {7, 3, 9, 11, 12};
        System.out.println("Sorted array: ");
        bubbleSortFirstTry(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }*/

        // Try 2: bubbleSortSecondTry
        /*int[] arr2 = {7, 12, 9, 11, 3};
        bubbleSortSecondTry(arr2);
        for (int num : arr2) {
            System.out.print(num + " ");
        }*/

        // Solution 1: bubbleSortFirstSolution
        /*int[] arr = {7, 12, 9, 11, 3};
        bubbleSortFirstSolution(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }*/

    }

    public static void bubbleSortFirstTry(int[] arr) { // Try 1
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                int a = arr[i];
                int b = arr[i + 1];

                if (a > b) {
                    int c = a + b;
                    arr[i] = c - a;
                    arr[i + 1] = c - b;
                }
            }
        }
    }

    public static void bubbleSortSecondTry(int[] arr) { // Try 2
        for (int i = 0; i < arr.length; i++) {
            bubbleSortFirstTry(arr);
        }
    }

    public static void bubbleSortFirstSolution(int[] arr) { // Solution 1
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                int a = arr[j];
                int b = arr[j + 1];

                if (a > b) {
                    arr[j] = b;
                    arr[j + 1] = a;
                }
            }
        }
    }

}
