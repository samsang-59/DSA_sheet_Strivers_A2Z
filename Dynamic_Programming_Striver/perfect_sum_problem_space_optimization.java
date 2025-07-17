package Dynamic_Programming_Striver;

public class perfect_sum_problem_space_optimization {
    public static int find_ans(int[] prevRow,int[] currRow,int[] arr,int target){
        if (arr[0] == 0) {
            prevRow[0] =  2; // pick and not-pick both give sum = 0
        } else {
            prevRow[0] =  1;// only not-pick gives sum = 0
        }

        if (arr[0] != 0 && arr[0] <= target) {
            prevRow[arr[0]] = 1; // only one subset that picks arr[0]
        }


        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int notPick = prevRow[j];
                int pick = 0;
                if (arr[i] <= j) {
                    pick = prevRow[j - arr[i]];
                }
                currRow[j] = pick + notPick;
            }
            prevRow = currRow;
            currRow = new int[target+1];
            currRow[0] = 1;
        }
        return prevRow[target];
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target = 1;
        int[] prevRow = new int[target+1];
        int[] currRow = new int[target+1];
        int ans = find_ans(prevRow,currRow,arr,target);
        System.out.println(ans);
    }
}
