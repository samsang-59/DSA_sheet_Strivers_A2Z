package Strivers_A2Z_DSA_Arrays;

public class largest_element_in_an_array {
    public static void main(String[] args) {
        int[] nums = {3,3,6,1};
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }

        System.out.println(max);
    }
}
