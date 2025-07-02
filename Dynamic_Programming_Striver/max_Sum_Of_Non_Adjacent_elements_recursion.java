package Dynamic_Programming_Striver;

public class max_Sum_Of_Non_Adjacent_elements_recursion {
    public static int find_ans(int[] arr,int index){
        if(index==0){
            return arr[index];
        }
        if(index<0) return 0;

        int  pick = arr[index] + find_ans(arr,index-2);
        int no_pick = 0 + find_ans(arr,index-1);
        return Math.max(pick,no_pick);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int ans = find_ans(arr,arr.length-1);
        System.out.println(ans);
    }
}
