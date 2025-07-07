package Dynamic_Programming_Striver;

public class minimum_path_sum_recursion {
    public static int find_ans(int[][] arr,int row,int col){
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(row==0 && col==0) return arr[row][col];

        int leftsum =  find_ans(arr,row,col-1);
        int upsum =  find_ans(arr,row-1,col);

        return arr[row][col] + Math.min(leftsum,upsum);
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = find_ans(arr,arr.length-1,arr[0].length-1);
        System.out.println(ans);
    }
}
