package Dynamic_Programming_Striver;

public class house_robber_II_space_Optimizzation {
    public static int find_ans(int[] arr,int start,int end){
        int prev = arr[start],prev2 = 0; // prev = dp[i-1] and prev2 = dp[i-2]

        for(int i=start+1;i<=end;i++){
            int pick = arr[i];
            if(i>start+1){
                pick = arr[i] + prev2;
            }
            int not_pick = 0 + prev;
            int curri = Math.max(pick,not_pick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        int n = arr.length;
        int ans1 = find_ans(arr,0,n-2);
        int ans2 = find_ans(arr,1,n-1);
        System.out.println(Math.max(ans1,ans2));
    }
}
