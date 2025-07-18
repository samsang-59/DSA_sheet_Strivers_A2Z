package Dynamic_Programming_Striver;

public class knapsack_problem_memoization {
    public static int find_ans(int[] wt,int[] val,int index,int target,int[][] dp){
        if(index==0){
            if(wt[index]<=target) return val[index];
            else return 0;
        }

        if(dp[index][target]!=-1) return dp[index][target];

        int take = Integer.MIN_VALUE;
        if(wt[index]<=target){
            take = val[index] + find_ans(wt,val,index-1,target-wt[index],dp);
        }
        int not_take = 0 + find_ans(wt,val,index-1,target,dp);
        dp[index][target] = Math.max(take,not_take);
        return dp[index][target];
    }
    public static void main(String[] args) {
        int[] wt = {5,4,2,3};
        int[] val = {10,40,30,50};
        int W = 5;

        int[][] dp = new int[wt.length][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(wt,val,wt.length-1,W,dp);
        System.out.println(ans);
    }
}
