package Dynamic_Programming_Striver;

public class house_robber_II_memoization {
    public static int find_from_first(int[] arr,int index,int[] dp){
        if (index == arr.length - 1) return arr[index];
        if (index > arr.length - 1) return 0;

        if(dp[index]!=-1) return dp[index];

        int pick = arr[index] + find_from_first(arr, index + 2,dp);
        int not_pick = find_from_first(arr, index + 1,dp);
        dp[index] = Math.max(pick, not_pick);
        return dp[index];
    }
    public static int find_from_last(int[] arr,int index,int[] dp){
        if(index==0) return arr[index];
        if(index<0) return 0;

        if(dp[index]!=-1) return dp[index];

        int pick = arr[index] + find_from_last(arr,index-2,dp);
        int not_pick = 0 + find_from_last(arr,index-1,dp);
        dp[index] = Math.max(pick,not_pick);
        return dp[index];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] dp1 = new int[arr.length];
        for(int i=0;i<dp1.length;i++){
            dp1[i] = -1;
        }
        int[] dp2 = new int[arr.length];
        for(int i=0;i<dp2.length;i++){
            dp2[i] = -1;
        }
        int ans1 = find_from_last(arr,arr.length-2,dp1);
        int ans2 = find_from_first(arr,1,dp2);
        System.out.println(Math.max(ans1,ans2));
    }
}
