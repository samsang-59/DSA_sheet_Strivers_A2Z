package Dynamic_Programming_Striver;

public class minFallingPathSum_recursion {
    public static int find_ans(int[][] matrix,int row,int col){
        if(row== matrix.length-1){
            return matrix[row][col];
        }

        int left_diagonal = Integer.MAX_VALUE;
        if(col>0){
            left_diagonal = find_ans(matrix,row+1,col-1);
        }

        int down = find_ans(matrix,row+1,col);

        int right_diagonal = Integer.MAX_VALUE;
        if(col< matrix[0].length-1){
            right_diagonal = find_ans(matrix,row+1,col+1);
        }

        return matrix[row][col] + Math.min(left_diagonal,Math.min(down,right_diagonal));
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int min = Integer.MAX_VALUE;
        for(int col=0;col< matrix[0].length;col++){
            min = Math.min(min,find_ans(matrix,0,col));
        }

        System.out.println(min);
    }
}
