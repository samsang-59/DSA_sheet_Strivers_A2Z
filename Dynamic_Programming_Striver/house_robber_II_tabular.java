package Dynamic_Programming_Striver;

public class house_robber_II_tabular {
//    public static int find_excluding_first(int[] arr,int start,int end,int[] dp){
//        dp[start] = arr[start];
//
//        for(int i = start-1;i>=end;i--){
//            int pick = arr[i];
//            if()
//        }
//    }
    public static int find_excluding_last(int[] arr,int start,int end,int[] dp){
        dp[start] = arr[start];

        for(int i=start+1;i<=end;i++){
            int pick = arr[i];
            if(i>1){
                pick = arr[i] + dp[i-2];
            }
            int not_pick = 0 + dp[i-1];
            dp[i] = Math.max(pick,not_pick);
        }
        return dp[end];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }

        // Case 1: Rob from 0 to n-2
        int[] dp1 = new int[arr.length];
        int ans1 = find_excluding_last(arr,0,arr.length-2,dp1);

        // Case 2: Rob from 1 to n-1
        int[] dp2 = new int[arr.length];
        int ans2 = find_excluding_last(arr,1,arr.length-1,dp2);

        System.out.println(Math.max(ans1, ans2));
    }
}
