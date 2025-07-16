package Dynamic_Programming_Striver;

public class Partition_equal_subset_sum_memoization {
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
        int[] arr = {1,2,3,5};
        int target = 0;
        for(int i=0;i<arr.length;i++){
            target += arr[i];
        }

        if(target%2!=0) {
            System.out.println(false);
            return;
        }

        target = target/2;
        Boolean[][] dp = new Boolean[arr.length][target+1];
        boolean ans = find_ans(arr,arr.length-1,target,dp);
        System.out.println(ans);
    }
}
