package Dynamic_Programming_Striver;

public class unique_Paths_withObstacles_recursion {
    public static int find_ans(int[][] arr,int row,int col){
        if(row<0 || col<0 || arr[row][col]==1) return 0;
        if(row==0 && col==0) return 1;


        int left = find_ans(arr,row-1,col);
        int up = find_ans(arr,row,col-1);

        return left + up ;
    }
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int ans = find_ans(arr,arr.length-1,arr[0].length-1);
        System.out.println(ans);
    }
}
