package Dynamic_Programming_Striver;

public class coin_change_tabulation {
    public static int find_ans(int[] arr,int target,int[][] dp){
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) dp[0][i] = i / arr[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int pick = (int)1e9;
                if(j>=arr[i]) pick = 1 + dp[i][j-arr[i]];
                int not_pick = 0 + dp[i-1][j];
                dp[i][j] = Math.min(pick,not_pick);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int amount = 4;
        int[][] dp = new int[arr.length][amount+1];
        int ans = find_ans(arr,amount,dp);
        if(ans>=(int)1e9) System.out.println(-1);
        else System.out.println(ans);
    }
}
