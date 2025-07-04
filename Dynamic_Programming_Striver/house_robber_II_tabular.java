package Dynamic_Programming_Striver;

public class house_robber_II_tabular {
    public static int find_from_first(int[] arr,int[] dp){
        dp[dp.length-1] = arr[arr.length-1];
        int pos = 0;

        for(int i=arr.length-2;i>=0;i--){
            int pick = arr[i];
            if(i<arr.length-2){
                pick = arr[i] + dp[i+2];
            }
            int not_pick = 0 + dp[i+1];
            dp[i] = Math.max(pick,not_pick);
        }

       return dp[0];
    }
    public static int find_from_last(int[] arr,int[] dp){
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
        int[] arr = {1,2,3};
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }

        // Case 1: Rob from 0 to n-2
        int[] temp1 = new int[arr.length - 1];
        for (int i = 0; i < temp1.length; i++) temp1[i] = arr[i];
        int[] dp1 = new int[temp1.length];
        int ans1 = find_from_last(temp1, dp1);

        // Case 2: Rob from 1 to n-1
        int[] temp2 = new int[arr.length - 1];
        for (int i = 0; i < temp2.length; i++) temp2[i] = arr[i + 1];
        int[] dp2 = new int[temp2.length];
        int ans2 = find_from_first(temp2, dp2);

        System.out.println(Math.max(ans1, ans2));
    }
}
