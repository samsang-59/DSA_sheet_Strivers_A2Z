package Dynamic_Programming_Striver;

public class max_sum_Non_Adjacent_elements_space_optimization {
    public static int find_ans(int[] arr){
        int prev = arr[0],prev2 = 0,curri = 0;
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1){
                pick = arr[i] + prev2;
            }
            int not_pick = 0 + prev;
            curri = Math.max(pick,not_pick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int ans = find_ans(arr);
        System.out.println(ans);
    }
}
