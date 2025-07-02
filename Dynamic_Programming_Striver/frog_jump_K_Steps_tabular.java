package Dynamic_Programming_Striver;

public class frog_jump_K_Steps_tabular {
    public static int find_ans(int[] height,int k,int[] dp){
        dp[0] = 0;
        for(int i=1;i<height.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i>=j){
                    int ans = dp[i-j] + Math.abs(height[i] - height[i-j]);
                    min = Math.min(ans,min);
                }
            }
            dp[i] = min;
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        int[] height = {10, 5, 20, 0, 15};
        int[] dp = new int[height.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_ans(height,2,dp);
        System.out.println(ans);
    }
}
