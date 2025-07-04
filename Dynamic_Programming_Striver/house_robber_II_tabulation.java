package Dynamic_Programming_Striver;

public class house_robber_II_tabulation {
    public static int find_ans(int[] arr,int start,int end,int[] dp){
       dp[start] = arr[start];

       for(int i=start+1;i<=end;i++){
           int pick = arr[i];
           if(i>start+1){
               pick = arr[i] + dp[i-2];
           }
           int not_pick = 0 + dp[i-1];
           dp[i] = Math.max(pick,not_pick);
       }
       return dp[end];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,2};
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
