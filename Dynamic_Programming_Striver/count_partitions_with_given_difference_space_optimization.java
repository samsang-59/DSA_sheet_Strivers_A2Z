package Dynamic_Programming_Striver;

public class count_partitions_with_given_difference_space_optimization {
    public static int find_ans(int[] PrevRow,int[] CurrRow,int target,int[] arr){
        if(arr[0]==0){
            PrevRow[0] = 2;
        }
        else {
            PrevRow[0] = 1;
        }
        if(arr[0]!=0 && arr[0]<=target){
            PrevRow[arr[0]] = 1;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int not_pick = PrevRow[j];
                int pick = 0;
                if(arr[i]<=j){
                    pick = PrevRow[j-arr[i]];
                }

                CurrRow[j] = pick + not_pick;
            }
            PrevRow = CurrRow;
            CurrRow = new int[target+1];
            CurrRow[0] = 1;
        }
        return PrevRow[target];
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
        int[] PrevRow = new int[target+1];
        int[] CurrRow = new int[target+1];
        int ans = find_ans(PrevRow,CurrRow,target,arr);
        System.out.println(ans);
    }
}
