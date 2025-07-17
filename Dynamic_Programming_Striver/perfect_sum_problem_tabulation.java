package Dynamic_Programming_Striver;

public class perfect_sum_problem_tabulation {
    public static int find_ans(int[] arr,int[][] dp,int target) {
        if (arr[0] == 0) {
            dp[0][0] = 2; // pick and not-pick both give sum = 0
        } else {
            dp[0][0] = 1; // only not-pick gives sum = 0
        }

        if (arr[0] != 0 && arr[0] <= target) {
            dp[0][arr[0]] = 1; // only one subset that picks arr[0]
        }


        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (arr[i] <= j) {
                    pick = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target = 1;
        int[][] dp = new int[arr.length][target+1];
        int ans = find_ans(arr,dp,target);
        System.out.println(ans);
    }
}
