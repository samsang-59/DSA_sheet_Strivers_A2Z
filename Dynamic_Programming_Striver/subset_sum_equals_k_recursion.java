package Dynamic_Programming_Striver;

public class subset_sum_equals_k_recursion {
    public static boolean find_ans(int[] arr,int index,int k){
        if(k<0) return false;
        if(k==0) {
            return true;
        }
        if(index==arr.length) return false;

        boolean take = false,not_take = false;
        if(index<arr.length){
         take = find_ans(arr,index+1,k-arr[index]);
         not_take = find_ans(arr,index+1,k);
        }
        return take || not_take;
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 100;
        boolean ans = find_ans(arr,0,target);
        System.out.println(ans);
    }
}
