package ro.vctr.learning;

import java.util.Arrays;
// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
// The digits are ordered from most significant to least significant in left-to-right order.
// The large integer does not contain any leading 0's.
// Increment the large integer by one and return the resulting array of digits.
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9){
                digits[i] = 0;
                if (i == 0) {
                    int[] temp = new int[digits.length+1];
                    temp[0] = 1;
                    System.arraycopy(digits, 0, temp, 1, digits.length);
                    digits = temp;
                    i = -1;
                }
            }
            else {
                digits[i]++;
                i = -1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9})));
    }
}
