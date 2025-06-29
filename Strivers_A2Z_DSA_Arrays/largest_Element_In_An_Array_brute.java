package Strivers_A2Z_DSA_Arrays;

import java.util.Arrays;

public class largest_Element_In_An_Array_brute {
    public static void main(String[] args) {
        int[] nums = {3,3,6,1};
        Arrays.sort(nums);
        int max_number = nums[nums.length-1];
        System.out.println(max_number);
    }
}
