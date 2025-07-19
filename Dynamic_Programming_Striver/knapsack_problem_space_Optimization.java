package Dynamic_Programming_Striver;

public class knapsack_problem_space_Optimization {
    public static int find_ans(int[] wt,int[] val,int[] PrevRow,int[] CurrRow,int target){
        for(int i=wt[0];i<=target;i++){
            if(i<=target) PrevRow[i] = val[0];
        }

        for(int i=1;i<wt.length;i++){
            for(int j=0;j<target+1;j++){
                int take = Integer.MIN_VALUE;
                if(wt[i]<=j){
                    take = val[i] + PrevRow[j-wt[i]];
                }
                int not_take = 0 + PrevRow[j];
                CurrRow[j] = Math.max(take,not_take);
            }
            PrevRow = CurrRow;
            CurrRow = new int[target+1];
            CurrRow[0] = 0;
        }
        return PrevRow[target];
    }
    public static void main(String[] args) {
        int[] wt = {5,4,2,3};
        int[] val = {10,40,30,50};
        int W = 5;

        int[] PrevRow = new int[W+1];
        int[] CurrRow = new int[W+1];
        int ans = find_ans(wt,val,PrevRow,CurrRow,W);
        System.out.println(ans);
    }
}
