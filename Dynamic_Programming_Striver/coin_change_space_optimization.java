package Dynamic_Programming_Striver;

public class coin_change_space_optimization {
    public static int find_ans(int[] arr,int target,int[] PrevRow,int[] CurrRow){
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) PrevRow[i] = i / arr[0];
            else PrevRow[i] = (int) 1e9;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                int pick = (int)1e9;
                if(j>=arr[i]) pick = 1 + CurrRow[j-arr[i]];
                int not_pick = 0 + PrevRow[j];
                CurrRow[j] = Math.min(pick,not_pick);
            }
            PrevRow = CurrRow;
            CurrRow = new int[target+1];
            CurrRow[0] = (int)1e9;
        }
        return PrevRow[target];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int amount = 4;
        int[] PrevRow = new int[amount+1];
        int[] CurrRow = new int[amount+1];
        int ans = find_ans(arr,amount,PrevRow,CurrRow);
        if(ans>=(int)1e9) System.out.println(-1);
        else System.out.println(ans);
    }
}
