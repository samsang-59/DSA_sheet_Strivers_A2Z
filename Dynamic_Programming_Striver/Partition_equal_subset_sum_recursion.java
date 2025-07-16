package Dynamic_Programming_Striver;

public class Partition_equal_subset_sum_recursion {
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
        int[] arr = {1,2,3,5};
        int target = 0;
        for(int i=0;i<arr.length;i++){
            target += arr[i];
        }

        if(target%2!=0) {
            System.out.println(false);
            return;
        }

        boolean ans = find_ans(arr,arr.length-1,target/2);
        System.out.println(ans);
    }
}
