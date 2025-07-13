package Dynamic_Programming_Striver;

public class subset_sum_equals_k_memoization {
    public static boolean find_ans(int[] arr,int index,int k,boolean[] dp){
        if(k<0) return false;
        if(k==0) {
            return true;
        }
        if(index==arr.length) return false;

        if(dp[index]!=false) return dp[index];

        boolean take = false,not_take = false;
        if(index<arr.length){
            take = find_ans(arr,index+1,k-arr[index],dp);
            not_take = find_ans(arr,index+1,k,dp);
        }
        dp[index] = take || not_take;
        return dp[index] ;
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 10;
        boolean[] dp = new boolean[arr.length];
        for(int i=0;i< dp.length;i++){
            dp[i] = false;
        }
        boolean ans = find_ans(arr,0,target,dp);
        System.out.println(ans);
    }
}
