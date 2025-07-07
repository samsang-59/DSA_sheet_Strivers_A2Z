package Dynamic_Programming_Striver;

public class unique_paths_space_optimization {
    public static int find_ans(int[][] arr){
        int[] prev = new int[arr[0].length];
        for(int row=0;row<arr.length;row++){
            int[] curr= new int[arr[0].length];
            for(int col=0;col<arr[0].length;col++){
                if(row==0 && col==0) curr[col] = 1;
                else{
                    int left = 0,up = 0;
                    if(col>0) left = curr[col-1];
                     if(row>0) up = prev[col];
                    curr[col]= left + up;
                }
            }
            prev = curr;
        }
        return prev[prev.length-1];
    }
    public static void main(String[] args) {
        int m=3,n=7;
        int[][] arr = new int[m][n];
        int ans = find_ans(arr);
        System.out.println(ans);
    }
}
