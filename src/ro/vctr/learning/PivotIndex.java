package ro.vctr.learning;
//Given an array of integers nums, calculate the pivot index of this array.
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//Return the leftmost pivot index. If no such index exists, return -1.
public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int pivot = -1;
        int numsLength = nums.length;

        for (int pivot_x = 0; pivot_x < numsLength; pivot_x++){
            int sumLeft = 0;
            int sumRight = 0;

            if (pivot_x > 0)
                for (int i = 0; i < pivot_x; i++) sumLeft += nums[i];
            if (pivot_x < numsLength-1)
                for (int i = pivot_x+1; i < numsLength; i++) sumRight += nums[i];

            System.out.println(pivot_x + "\t" + sumLeft + "\t" + sumRight);
            if (sumLeft == sumRight){
                pivot = pivot_x;
                break;
            }
        }

        return pivot;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 24, 4, 8, 3, 6, 8}));
        System.out.println();
        System.out.println(pivotIndex(new int[]{-1, -24, -4, 8, 15, 6, 8}));
        System.out.println();
        System.out.println(pivotIndex(new int[]{8, -24, -4, 8, 15, 6, -1}));
    }
}
