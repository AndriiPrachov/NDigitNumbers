import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfDigits = in.nextInt();

        int numOfNums = numOfNumbersUsingDigits(numOfDigits);
        System.out.println("Digits: " + numOfDigits + "; number: " + numOfNums);
        printDigits(numOfNums);
    }

    private static int calc(int n) {
        return  (int) (9 * Math.pow(10, n - 1));
    }

    private static int numOfNumbersUsingDigits(int numOfDigits) {
        int counter = 0;
        for (int i = 1; ; i++) {
            int calc = calc(i);
            int localRes = numOfDigits - calc * i;
            if (localRes < 0) {
                counter += numOfDigits / i;
                break;
            } else {
                counter += calc;
                numOfDigits = localRes;
            }
        }

        return counter;
    }

    private static void printDigits(int numOfNums) {
        int digitsCounter = 0;
        for (int i = 1; i <= numOfNums; i++) {
            System.out.println();
            System.out.print(i + ": ");
            int j = i;
            while (j > 0) {
                ++digitsCounter;
                System.out.print(" " + digitsCounter);
                j /= 10;
            }
        }

        System.out.println();
        System.out.println("Result: number == " + numOfNums + "; digits == " + digitsCounter);
    }
}
