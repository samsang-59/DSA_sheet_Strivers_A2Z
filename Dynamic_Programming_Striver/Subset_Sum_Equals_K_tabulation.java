package Dynamic_Programming_Striver;

public class Subset_Sum_Equals_K_tabulation {
    public static boolean find_ans(int[] arr,Boolean[][] dp,int target){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=target){
            dp[0][arr[0]] = true;
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean take = false;
                if(arr[i]<=j && dp[i - 1][j - arr[i]] != null){
                    take = dp[i-1][j-arr[i]];
                }
                boolean not_take = false;
                if(dp[i - 1][j] != null){
                    not_take = dp[i-1][j];
                }

               dp[i][j] = take || not_take ;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        int target = 3;
        Boolean[][] dp = new Boolean[arr.length][target+1];
        boolean ans = find_ans(arr,dp,target);
        System.out.println(ans);
    }
}
