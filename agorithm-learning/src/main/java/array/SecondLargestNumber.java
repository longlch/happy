package array;

/*
 * https://www.geeksforgeeks.org/find-second-largest-element-array/
 * */
public class SecondLargestNumber {
    public static int findSecondLargestNumber(int inputs[]) {
        int firstMax, secondMax;
        firstMax = secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] > firstMax) {
                secondMax = firstMax;
                firstMax = inputs[i];

            } else if (inputs[i] > secondMax && inputs[i] != firstMax) {
                secondMax = inputs[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
//        int inputs [] = {12, 35, 1, 10, 34, 1}; // 34
//        int inputs [] = {10, 5, 10}; // 5
        int inputs[] = {10, 10, 10}; // No number
        System.out.println(findSecondLargestNumber(inputs));
    }
}
