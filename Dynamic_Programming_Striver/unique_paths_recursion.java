package Dynamic_Programming_Striver;

public class unique_paths_recursion {
    public static int find_ans(int[][] arr,int row,int col,int m,int n){
        if(row<0 || col<0) return 0;
        if(row==0 && col==0) return 1;

        int right = find_ans(arr,row-1,col,m,n);
        int down = find_ans(arr,row,col-1,m,n);

        return right + down ;
    }

    public static void main(String[] args) {
        int m=3,n=7;
        int[][] arr = new int[m][n];
        int ans = find_ans(arr,m-1,n-1,m,n);
        System.out.println(ans);
    }
}
