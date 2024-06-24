package array;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/
 * */
public class FindTopThreeNumber {

    public static void findTopThreeNumberVer2(int inputs[]) {

        if (inputs.length < 3) {
            System.out.println("Invalid input");
            return;
        }

        int first, second, third;
        first = second = third = Integer.MIN_VALUE;

        for (int i = 0; i < inputs.length; i++) {

            if (inputs[i] > first) {
                third = second;
                second = first;
                first = inputs[i];

            } else if (inputs[i] > second && inputs[i] != first) {
                third = second;
                second = inputs[i];

            } else if (inputs[i] > third && inputs[i] != second) {
                third = inputs[i];
            }
//            System.out.println(String.format("%s, %s, %s", first, second, third));
        }

        System.out.println(String.format("%s, %s, %s", first, second, third));

    }

    public static void findTopThreeNumberVer3(int inputs[]) {

        Arrays.sort(inputs);
        int count = 0, check = inputs[0];
        for (int i = inputs.length - 1; i >= 0; i--) {

            if (count < 3) {
                if (check != inputs[i]) {
                    System.out.print(inputs[i] + ", ");
                    check = inputs[i];
                    count++;
                }
            }

        }
    }


    public static void main(String[] args) {
        int inputs[] = {12, 45, 1, -1, 45, 54, 23, 5, 0, -10};
        findTopThreeNumberVer2(inputs);
        findTopThreeNumberVer3(inputs);
    }
}
