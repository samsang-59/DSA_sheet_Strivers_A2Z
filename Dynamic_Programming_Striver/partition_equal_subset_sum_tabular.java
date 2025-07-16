package Dynamic_Programming_Striver;

public class partition_equal_subset_sum_tabular {
    public static boolean find_ans(int[] arr,boolean[][] dp,int target){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=target){
            dp[0][arr[0]] = true;
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean take = false;
                if(arr[i]<=j ){
                    take = dp[i-1][j-arr[i]];
                }
                boolean not_take = dp[i-1][j];

                dp[i][j] = take || not_take ;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
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
        boolean[][] dp = new boolean[arr.length][target+1];
        boolean ans = find_ans(arr,dp,target);
        System.out.println(ans);
    }
}
