package Dynamic_Programming_Striver;

public class ninja_problem_memoization {
    public static int find_max_points(int index,int PrevTask,int[][] arr,int[][] dp){
        if(index==0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<arr[0].length;i++){
                if(i!=PrevTask){
                    max = Math.max(max,arr[index][i]);
                }
            }
            return max;
        }

        if(dp[index][PrevTask]!=-1) return dp[index][PrevTask];


        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr[0].length;i++){
            if(i!=PrevTask){
                int points = arr[index][i] +  find_max_points(index-1,i,arr,dp);
                max = Math.max(max,points);
            }
        }
        dp[index][PrevTask] = max;
        return dp[index][PrevTask];
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int numsTask = arr[0].length;
        int[][] dp = new int[arr.length][numsTask+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<numsTask+1;j++){
                dp[i][j] = -1;
            }
        }
        int ans = find_max_points(arr.length-1,numsTask,arr,dp);
        System.out.println(ans);
    }
}
