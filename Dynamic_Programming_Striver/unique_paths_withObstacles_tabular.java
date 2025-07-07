package Dynamic_Programming_Striver;

public class unique_paths_withObstacles_tabular {
    public static int find_ans(int[][] arr, int[][] dp){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if((row==0 && col==0) && (arr[row][col]!=1)) dp[row][col] = 1;
                else{
                        int left = 0,up = 0;
                        if(col>0 && arr[row][col]!=1) left = dp[row][col-1];
                        if(row>0 && arr[row][col]!=1) up = dp[row-1][col];
                        dp[row][col] = left + up;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] dp = new int[arr.length][arr[0].length];
        int ans = find_ans(arr,dp);
        System.out.println(ans);
    }
}
