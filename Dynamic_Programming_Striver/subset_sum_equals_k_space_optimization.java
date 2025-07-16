package Dynamic_Programming_Striver;

public class subset_sum_equals_k_space_optimization {
    public static boolean find_ans(Boolean[] prevRow,Boolean[] currRow,int[] arr,int target){
        prevRow[0] = true;
        currRow[0] = true;
        if(arr[0]<=target){
            prevRow[arr[0]] = true;
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean take = false;
                if(arr[i]<=j && prevRow[j - arr[i]] != null){
                    take = prevRow[j-arr[i]];
                }
                boolean not_take = false;
                if(prevRow[j] != null){
                    not_take = prevRow[j];
                }

                currRow[j] = take || not_take ;
            }
            prevRow = currRow;
            currRow = new Boolean[target + 1]; // reinitialize for next row
            currRow[0] = true; // base case
        }

        return prevRow[target];
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        int target = 3;
        Boolean[] prev = new Boolean[target+1];
        Boolean[] curr = new Boolean[target+1];

        boolean ans = find_ans(prev,curr,arr,target);
        System.out.println(ans);
    }
}
