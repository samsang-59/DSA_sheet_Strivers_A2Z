package Dynamic_Programming_Striver;

public class perfect_sum_problem_recursion {
    public static int find_ans(int[] arr,int index,int target){
        if(target<0) return 0;
        if(index == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }

        int not_pick = find_ans(arr,index-1,target);
        int pick = 0;
        if(arr[index]<=target){
            pick = find_ans(arr,index-1,target-arr[index]);
        }
        return pick + not_pick ;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target = 1;
        int ans = find_ans(arr,arr.length-1,target);
        System.out.println(ans);
    }
}
