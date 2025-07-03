package Dynamic_Programming_Striver;

public class house_robber_II_recursion {
    public static int find_from_first(int[] arr,int index){
        if (index == arr.length - 1) return arr[index];
        if (index > arr.length - 1) return 0;

        int pick = arr[index] + find_from_first(arr, index + 2);
        int not_pick = find_from_first(arr, index + 1);
        return Math.max(pick, not_pick);
    }
    public static int find_from_last(int[] arr,int index){
        if(index==0) return arr[index];
        if(index<0) return 0;

        int pick = arr[index] + find_from_last(arr,index-2);
        int not_pick = 0 + find_from_last(arr,index-1);
        return Math.max(pick,not_pick);
    }
    public static void main(String[] args) {
        int[] arr = {1};
        int ans1 = find_from_last(arr,arr.length-2);
        int ans2 = find_from_first(arr,1);
        System.out.println(Math.max(ans1,ans2));
    }
}
