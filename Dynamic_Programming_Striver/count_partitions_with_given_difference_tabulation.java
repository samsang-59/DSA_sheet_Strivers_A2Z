package Dynamic_Programming_Striver;

public class count_partitions_with_given_difference_tabulation {
    public static int find_ans(int[] arr,int[][] dp,int target){
        if(arr[0]==0){
            dp[0][0] = 2;
        }
        else {
            dp[0][0] = 1;
        }
        if(arr[0]!=0 && arr[0]<=target){
            dp[0][arr[0]] = 1;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int not_pick = dp[i-1][j];
                int pick = 0;
                if(arr[i]<=j){
                    pick = dp[i-1][j-arr[i]];
                }

                dp[i][j] = pick + not_pick;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int d = 0;
        int totalsum = 0;
        for(int i=0;i<arr.length;i++){
            totalsum += arr[i];
        }

        if((totalsum - d) < 0 || (totalsum - d) % 2 != 0){
            System.out.println(0); // No valid partition possible
            return;
        }

        int target = (totalsum-d)/2;
        int[][] dp = new int[arr.length][target+1];
        int ans = find_ans(arr,dp,target);
        System.out.println(ans);
    }
}
