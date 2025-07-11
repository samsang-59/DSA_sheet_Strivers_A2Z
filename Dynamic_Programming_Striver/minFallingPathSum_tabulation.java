package Dynamic_Programming_Striver;

public class minFallingPathSum_tabulation {
    public static int find_ans(int[][] matrix,int[][] dp){
        for(int col = 0;col< matrix[0].length;col++){
            dp[dp.length-1][col] = matrix[matrix.length-1][col];
        }

        for(int row = matrix.length-2;row>=0;row--){
            for(int col=0;col< matrix[0].length;col++){
                int left_diagonal = Integer.MAX_VALUE;
                if(col>0){
                    left_diagonal = dp[row+1][col-1];
                }

                int down = dp[row+1][col];

                int right_diagonal = Integer.MAX_VALUE;
                if(col< matrix[0].length-1){
                    right_diagonal = dp[row+1][col+1];
                }

                dp[row][col] = matrix[row][col] + Math.min(left_diagonal,Math.min(down,right_diagonal));
            }
        }

        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            minimum = Math.min(minimum,dp[0][i]);
        }
        return minimum;
    }
    public static void main(String[] args) {
//        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix = {{-19,57},{-40,-5}};

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                dp[i][j] = -1;
            }
        }

        int ans = find_ans(matrix,dp);

        System.out.println(ans);
    }
}
