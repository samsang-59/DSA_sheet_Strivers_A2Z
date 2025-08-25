package Dynamic_Programming_Striver;

import java.util.ArrayList;

public class targetSum_memoization {
    public static int find_ans(int[] arr,int index,int target,int[][] dp){
        if(index==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            else return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];

        int pick = 0;
        if(target>=arr[index]) pick = find_ans(arr,index-1,target-arr[index],dp);
        int not_pick = find_ans(arr,index-1,target,dp);
        dp[index][target] = pick + not_pick;
        return dp[index][target];
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

//        using logic of s1 - s2 = d ;

        int total_sum = 0;
        for(int i=0;i<nums.length;i++){
            total_sum += nums[i];
        }

        if(total_sum-target<0 || (total_sum-target)%2!=0) System.out.println("not possible");

        int s2 = (total_sum-target)/2;
        int[][] dp = new int[nums.length][s2+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        int ans = find_ans(nums,nums.length-1,s2,dp);
        System.out.println(ans);
    }

}
