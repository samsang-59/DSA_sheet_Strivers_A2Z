package Dynamic_Programming_Striver;

public class frog_jump_tabular {
    public static int find_ans(int[] height,int[] dp){
       dp[0] = 0;
       for(int i=1;i<height.length;i++){
           int left = dp[i-1] + Math.abs(height[i] - height[i-1]);
           int right = Integer.MAX_VALUE;
           if(i>1){
               right = dp[i-2] + Math.abs(height[i] - height[i-2]);
           }
           dp[i] = Math.min(left,right);
       }
       return dp[dp.length-1];
    }
    public static void main(String[] args) {
        int[] height = {20,30,40,20};
        int[] dp = new int[height.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int ans = find_ans(height,dp);
        System.out.println(ans);
    }
}
