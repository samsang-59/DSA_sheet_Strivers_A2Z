package Dynamic_Programming_Striver;

public class house_robber_II_recursion_Part_II {
    public static int find_ans(int[] arr,int start,int end){
        if(end == start) return arr[end];
        if(end < 0) return 0;

        int pick = arr[end] + find_ans(arr,start,end-2);
        int not_pick = 0 + find_ans(arr,start,end-1);
        return Math.max(pick,not_pick);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int n = arr.length;
        int ans1 = find_ans(arr,0,n-2);
        int ans2 = find_ans(arr,1,n-1);
        System.out.println(Math.max(ans1,ans2));
    }
}
