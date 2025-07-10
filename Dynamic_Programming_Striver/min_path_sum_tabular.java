package Dynamic_Programming_Striver;

public class min_path_sum_tabular {
    public static int find_ans(int[][] dp,int[][] grid){
        for(int row=0;row< grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(row==0 && col==0) dp[row][col] = grid[row][col];
                else{
                    int left = Integer.MAX_VALUE,up = Integer.MAX_VALUE;
                    if(col>0) left = dp[row][col-1];
                    if(row>0) up = dp[row-1][col];
                    dp[row][col] = grid[row][col] + Math.min(left,up);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[grid.length][grid[0].length];
        int ans = find_ans(dp,grid);
        System.out.println(ans);
    }
}
