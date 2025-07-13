package Dynamic_Programming_Striver;

public class Subset_Sum_Equals_K_correct_memoization {
    public static boolean find_ans(int[] arr,int index,int target,Boolean[][] dp){
        if(target==0) return true;
        if(target<0) return false;
        if(index==0) {
            if(arr[index]==target) return true;
            else return false;
        }

        if(dp[index][target]!=null) return dp[index][target];

        boolean take = find_ans(arr,index-1,target-arr[index],dp);
        boolean not_take = find_ans(arr,index-1,target,dp);

        dp[index][target] = take || not_take;

        return dp[index][target];
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 10;
        Boolean[][] dp = new Boolean[arr.length][target+1];
        boolean ans = find_ans(arr,arr.length-1,target,dp);
        System.out.println(ans);
    }
}
