package Dynamic_Programming_Striver;

public class unique_paths_tabular {
    public static int find_ans(int[][] arr,int[][] dp){


        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                if(row==0 && col==0) dp[row][col] = 1;
                else{
                    int left = 0,up = 0;
                    if(col>0) left = dp[row][col-1];
                    if(row>0) up = dp[row-1][col];
                    dp[row][col] = left + up;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int m=3,n=3;
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        int ans = find_ans(arr,dp);
        System.out.println(ans);
    }
}
