package Dynamic_Programming_Striver;

public class max_sum_Non_Adjacent_elements_tabular {
    public static int find_ans(int[] arr,int[] dp){
        dp[0] = arr[0];
        int neg = 0;
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1){
                pick = arr[i] + dp[i-2];
            }
            int not_pick = 0 + dp[i-1];
            dp[i] = Math.max(pick,not_pick);
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int[] dp = new int[arr.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_ans(arr,dp);
        System.out.println(ans);
    }
}
