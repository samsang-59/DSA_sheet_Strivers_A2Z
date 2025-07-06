package Dynamic_Programming_Striver;

public class unique_paths_withObstacles_memoization {
    public static int find_ans(int[][] arr,int row,int col,int[][] dp){
        if(row<0 || col<0 || arr[row][col]==1) return 0;
        if(row==0 && col==0) return 1;

        if(dp[row][col]!=-1) return dp[row][col];

        int left = find_ans(arr,row-1,col,dp);
        int up = find_ans(arr,row,col-1,dp);

        dp[row][col] = left + up ;

        return dp[row][col];
    }
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(arr,arr.length-1,arr[0].length-1,dp);
        System.out.println(ans);
    }
}
