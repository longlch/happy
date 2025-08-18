package w3school.array;

public class BubbleSort {
    public static void main(String[] args) {
        // Solution 1: bubbleSortRunOneTime
        /*int[] arr = {7, 12, 9, 11, 3};
        //int[] arr = {7, 9, 11, 3, 12};
        //int[] arr = {7, 9, 3, 11, 12};
        //int[] arr = {7, 3, 9, 11, 12};
        System.out.println("Sorted array: ");
        bubbleSortRunOneTime(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }*/

        // Solution 2: bubbleSortComplete
        int[] arr2 = {7, 12, 9, 11, 3};
        bubbleSortComplete(arr2);
        for (int num : arr2) {
            System.out.print(num + " ");
        }

    }

    public static void bubbleSortRunOneTime(int[] arr) { // Solution 1
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

    public static void bubbleSortComplete(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            bubbleSortRunOneTime(arr);
        }
    }
}
