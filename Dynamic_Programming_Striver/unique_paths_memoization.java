package Dynamic_Programming_Striver;

public class unique_paths_memoization {
    public static int find_ans(int[][] arr,int row,int col,int m,int n,int[][] dp){
        if(row<0 || col<0) return 0;
        if(row==0 && col==0) return 1;

        if(dp[row][col]!=-1) return dp[row][col];

        int right = find_ans(arr,row-1,col,m,n,dp);
        int down = find_ans(arr,row,col-1,m,n,dp);

        dp[row][col] = right + down ;

        return dp[row][col];
    }
    public static void main(String[] args) {
        int m=3,n=7;
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(arr,m-1,n-1,m,n,dp);
        System.out.println(ans);
    }
}
