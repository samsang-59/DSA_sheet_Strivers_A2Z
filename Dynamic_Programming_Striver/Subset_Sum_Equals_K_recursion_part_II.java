package Dynamic_Programming_Striver;

public class Subset_Sum_Equals_K_recursion_part_II {
    public static boolean find_ans(int[] arr,int index,int target){
        if(target==0) return true;
        if(target<0) return false;
        if(index==0) {
            if(arr[index]==target) return true;
            else return false;
        }

        boolean take = find_ans(arr,index-1,target-arr[index]);
        boolean not_take = find_ans(arr,index-1,target);

        return take || not_take;
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 10;
        boolean ans = find_ans(arr,arr.length-1,target);
        System.out.println(ans);
    }
}
