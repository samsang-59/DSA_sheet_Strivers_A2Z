package Dynamic_Programming_Striver;

public class frog_jump_k_Steps_memoization {
    public static int find_ans(int[] height,int index,int k,int[] dp){
        if(index==0){
            return 0;
        }

        if(dp[index]!=-1) return dp[index];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            int jump_Energy = 0;
            if(index>=i){
                jump_Energy = find_ans(height,index-i,k,dp) + Math.abs(height[index] - height[index-i]);
            }
            min = Math.min(jump_Energy,min);
            dp[index] = min;
        }

        return dp[index];
    }
    public static void main(String[] args) {
        int[] height = {10, 5, 20, 0, 15};
        int[] dp = new int[height.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_ans(height,height.length-1,2,dp);
        System.out.println(ans);
    }
}
