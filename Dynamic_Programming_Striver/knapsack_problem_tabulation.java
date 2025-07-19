package Dynamic_Programming_Striver;

public class knapsack_problem_tabulation {
    public static int find_ans(int[] wt,int[] val,int[][] dp,int target){
        for(int i=wt[0];i<=target;i++){
            if(i<=target) dp[0][i] = val[0];
        }

        for(int i=1;i<wt.length;i++){
            for(int j=0;j<target+1;j++){
                int take = Integer.MIN_VALUE;
                if(wt[i]<=j){
                    take = val[i] + dp[i-1][j-wt[i]];
                }
                int not_take = 0 + dp[i-1][j];
                dp[i][j] = Math.max(take,not_take);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] wt = {5,4,2,3};
        int[] val = {10,40,30,50};
        int W = 5;

        int[][] dp = new int[wt.length][W+1];
        int ans = find_ans(wt,val,dp,W);
        System.out.println(ans);
    }
}
