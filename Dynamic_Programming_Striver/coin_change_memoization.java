package Dynamic_Programming_Striver;

public class coin_change_memoization {
    public static int find_ans(int[] arr,int index,int target,int[][] dp){
        if(index == 0){
            if(target%arr[0]==0){
                return target/arr[0];
            }
            else return (int)1e9;
        }

        if(dp[index][target]!=-1) return dp[index][target];

        int pick = (int)1e9;
        if(target>=arr[index]) pick = 1 + find_ans(arr,index,target-arr[index],dp);
        int not_pick = 0 + find_ans(arr,index-1,target,dp);
        dp[index][target] = Math.min(pick,not_pick);
        return dp[index][target];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int amount = 11;
        int[][] dp = new int[arr.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(arr,arr.length-1,amount,dp);
        if(ans>=(int)1e9) System.out.println(-1);
        else System.out.println(ans);
    }
}
