package Dynamic_Programming_Striver;

public class ninja_problem_tabular {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int numsTask = arr[0].length;
        int[][] dp = new int[arr.length][numsTask+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<numsTask+1;j++){
                dp[i][j] = -1;
            }
        }

        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int day = 1;day<arr[0].length;day++){
            for(int prevtask = 0;prevtask<numsTask+1;prevtask++){
                dp[day][prevtask] = 0;
                int max = Integer.MIN_VALUE;
                for(int i=0;i<numsTask;i++){
                    if(i!=prevtask){
                        int points = arr[day][i] + dp[day-1][i];
                        max = Math.max(max,points);
                    }
                }
                dp[day][prevtask] = max;
            }
        }

        int ans = dp[dp.length-1][dp[0].length-1];
        System.out.println(ans);
    }
}
