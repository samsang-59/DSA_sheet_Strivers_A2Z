package Dynamic_Programming_Striver;

public class max_sum_Non_Adjacent_elements_memoization {
    public static int find_ans(int[] arr,int index,int[] dp){
        if(index==0){
            return arr[index];
        }
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];

        int  pick = arr[index] + find_ans(arr,index-2,dp);
        int no_pick = 0 + find_ans(arr,index-1,dp);
        dp[index] = Math.max(pick,no_pick);
        return dp[index];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int[] dp = new int[arr.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_ans(arr,arr.length-1,dp);
        System.out.println(ans);
    }
}
