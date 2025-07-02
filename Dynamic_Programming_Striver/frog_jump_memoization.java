package Dynamic_Programming_Striver;

public class frog_jump_memoization {
    public static int find_Min_Cost(int[] height,int index,int[] dp){
        if(index==0){
            return 0;
        }

        if(dp[index]!=-1) return dp[index];

        int left = find_Min_Cost(height, index-1,dp) + Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index>1){
            right = find_Min_Cost(height,index-2,dp) + Math.abs(height[index] - height[index-2]);
        }

        dp[index] = Math.min(left,right);
        return dp[index];
    }
    public static void main(String[] args) {
        int[] height = {20,30,40,20};
        int[] dp = new int[height.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_Min_Cost(height,height.length-1,dp);
        System.out.println(ans);
    }
}
