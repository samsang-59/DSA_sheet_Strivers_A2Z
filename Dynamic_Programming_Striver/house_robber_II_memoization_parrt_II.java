package Dynamic_Programming_Striver;

public class house_robber_II_memoization_parrt_II {
    public static int find_ans(int[] arr,int start,int end,int[] dp){
        if(end == start) return arr[end];
        if(end < start) return 0;

        if(dp[end]!=-1) return dp[end];

        int pick = arr[end] + find_ans(arr,start,end-2,dp);
        int not_pick = 0 + find_ans(arr,start,end-1,dp);
        dp[end] = Math.max(pick,not_pick);
        return dp[end];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i=0;i<dp1.length;i++){
            dp1[i] = -1;
            dp2[i] = -1;
        }
        int ans1 = find_ans(arr,0,n-2,dp1);
        int ans2 = find_ans(arr,1,n-1,dp2);
        System.out.println(Math.max(ans1,ans2));
    }
}
