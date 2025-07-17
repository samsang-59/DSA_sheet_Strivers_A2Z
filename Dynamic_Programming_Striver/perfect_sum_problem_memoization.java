package Dynamic_Programming_Striver;

public class perfect_sum_problem_memoization {
    public static int find_ans(int[] arr,int index,int target,int[][] dp){
        if(target<0) return 0;
        if(index == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if(dp[index][target]!=-1) return dp[index][target];

        int pick = find_ans(arr,index-1,target-arr[index],dp);
        int not_pick = find_ans(arr,index-1,target,dp);
        dp[index][target] = pick + not_pick;
        return dp[index][target];
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target = 1;
        int[][] dp = new int[arr.length][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(arr,arr.length-1,target,dp);
        System.out.println(ans);
    }
}
