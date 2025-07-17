package Dynamic_Programming_Striver;

public class count_partitions_with_given_difference_recursion {
    public static int find_ans(int[] arr,int index,int target){
        if(target<0) return 0;
        if(index == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }


        int pick = find_ans(arr,index-1,target-arr[index]);
        int not_pick = find_ans(arr,index-1,target);
        return pick + not_pick;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int d = 0;
        int totalsum = 0;
        for(int i=0;i<arr.length;i++){
            totalsum += arr[i];
        }

        if((totalsum - d) < 0 || (totalsum - d) % 2 != 0){
            System.out.println(0); // No valid partition possible
            return;
        }


        int target = (totalsum-d)/2;
        int ans = find_ans(arr,arr.length-1,target);
        System.out.println(ans);
    }
}
