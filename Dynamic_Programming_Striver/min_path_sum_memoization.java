package Dynamic_Programming_Striver;

public class min_path_sum_memoization {
    public static int find_ans(int[][] arr,int row,int col,int[][] dp){
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(row==0 && col==0) return arr[row][col];

        if(dp[row][col]!=-1) return dp[row][col];

        int leftsum =  find_ans(arr,row,col-1,dp);
        int upsum =  find_ans(arr,row-1,col,dp);

        dp[row][col] = arr[row][col] + Math.min(leftsum,upsum);
        return dp[row][col] ;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_ans(arr,arr.length-1,arr[0].length-1,dp);
        System.out.println(ans);
    }
}
