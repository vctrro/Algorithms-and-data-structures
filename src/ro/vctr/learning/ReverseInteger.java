package ro.vctr.learning;
// Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer range, then return 0.
public class ReverseInteger {

    public static int reverse(int x) {

        if (x == 0) return 0;

        int numberLength = (int) (Math.floor(Math.log10(Math.abs(x))) + 1);
        int y = 0, temp;

        for (int i = numberLength; i > 0 ; i--){
            temp = x%10;
//            System.out.println(temp);
            x = x/10;
//            System.out.println(x);

            y += temp * Math.pow(10, i-1);
            if (y == Integer.MAX_VALUE || y == Integer.MIN_VALUE) return 0;
//            System.out.println(y);
//            System.out.println();
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(reverse(124748364));
    }
}
