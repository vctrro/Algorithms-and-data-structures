package ro.vctr.learning;
//You are given an integer array nums where the largest integer is unique.
//Determine whether the largest element in the array is at least twice as much as every other number in the array.
// If it is, return the index of the largest element, or return -1 otherwise.
public class LargestNumber {

    public static int largestNumberIndex(int[] nums) {
        int index = 0;
        int largestNumber = 0, previousNumber = 0;
        for (int i = 0; i < nums.length; i++){
            if (largestNumber < nums[i]) {
                previousNumber = largestNumber;
                largestNumber = nums[i];
                index = i;
            } else if (previousNumber < nums[i]){
                previousNumber = nums[i];
            }
        }
        if (largestNumber < previousNumber*2) index = -1;
        return index;
    }


    public static void main(String[] args) {
        System.out.println(largestNumberIndex(new int[]{1, 21, 4, 8, 3, 6, 48}));
    }
}
