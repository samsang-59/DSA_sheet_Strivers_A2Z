package Dynamic_Programming_Striver;

public class Target_Sum_recursion {
    public static int find_ans(int[] nums,int index,int target){
       if(index==-1){
           if(target==0) return 1;
           else return 0;
       }
        int plus = find_ans(nums,index-1,target-nums[index]);
        int minus = find_ans(nums,index-1,target+nums[index]);
        return plus + minus;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int ans = find_ans(nums,nums.length-1,target);
        System.out.println(ans);
    }
}
