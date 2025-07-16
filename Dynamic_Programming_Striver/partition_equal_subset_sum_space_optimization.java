package Dynamic_Programming_Striver;

public class partition_equal_subset_sum_space_optimization {
    public static boolean find_ans(boolean[] prevRow,boolean[] currRow,int[] arr,int target){
        prevRow[0] = true;
        currRow[0] = true;
        if(arr[0]<=target){
            prevRow[arr[0]] = true;
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean take = false;
                if(arr[i]<=j ){
                    take = prevRow[j-arr[i]];
                }
                boolean not_take = prevRow[j];

                currRow[j] = take || not_take ;
            }
            prevRow = currRow;
            currRow = new boolean[target + 1]; // reinitialize for next row
            currRow[0] = true; // base case
        }

        return prevRow[target];
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

        target = target/2;

        boolean[] prev = new boolean[target+1];
        boolean[] curr = new boolean[target+1];

        boolean ans = find_ans(prev,curr,arr,target);
        System.out.println(ans);
    }
}
