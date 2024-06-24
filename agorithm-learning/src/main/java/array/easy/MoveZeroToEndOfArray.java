package array.easy;

import java.util.Arrays;

// https://www.geeksforgeeks.org/move-zeroes-end-array/
public class MoveZeroToEndOfArray {

    public static int[] moveZero(int[] inputs) { // Failed: due to change the position

        int allZeroElement = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == 0) {
                allZeroElement++;
            }
        }

        int finalPosition = inputs.length - 1;
        int countToMove = 0;

        for (int i = finalPosition; i > 0; i--) {

            if (countToMove < allZeroElement) {

                if (inputs[i] == 0) {
                    int temp = inputs[finalPosition - countToMove];
                    inputs[i] = temp;
                    inputs[finalPosition - countToMove] = 0;

                    countToMove++;
                }
            }
        }


        return inputs;
    }

    public static int[] moveZero2(int[] inputs) {
        int outputs[] = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            int currentElement = inputs[i];

            if (currentElement == 0) {

                if (i + 1 >= inputs.length) {
                    System.out.println("break");
                    break;
                }

                int temp = inputs[i];
                inputs[i] = inputs[i + 1];
                inputs[i + 1] = temp;

            }

            outputs[i] = inputs[i];
        }


        return outputs;
    }

    public static int[] moveZero3(int[] inputs) {
        int outputs[] = new int[inputs.length];

        int zeroPosition = 0;
        for (int i = 0; i < inputs.length; i++) {
            int currentElement = inputs[i];

            if (currentElement == 0) {
                if (currentElement != inputs[zeroPosition]) {
                    zeroPosition = i;
                }
            } else {
                swap(inputs, zeroPosition, i);
                zeroPosition++;
            }

            outputs[i] = inputs[i];
        }


        return inputs;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void pushZerosToEnd(int arr[], int n) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
//        int inputs [] = {1, 2, 0, 4, 3, 0, 5, 0};
//        Arrays.stream(moveZero(inputs)).forEach(System.out::println);

//        int inputs [] = {1, 2, 0, 4, 3, 0, 5, 0};
//        int inputs [] = {5, 6, 0, 4, 6, 0, 9, 0, 8};
        int inputs[] = {1, 2, 0, 0, 0, 3, 6};
        Arrays.stream(moveZero3(inputs)).forEach(i -> System.out.print(i + ", "));


    }
}
