package Dynamic_Programming_Striver;

public class Knapsack_problem_recursion {
    public static int find_ans(int[] wt,int[] val,int index,int target){
        if(index==0){
            if(wt[index]<=target) return val[index];
            else return 0;
        }

        int take = Integer.MIN_VALUE;
        if(wt[index]<=target){
            take = val[index] + find_ans(wt,val,index-1,target-wt[index]);
        }
        int not_take = 0 + find_ans(wt,val,index-1,target);
        return Math.max(take,not_take);
    }
    public static void main(String[] args) {
        int[] wt = {5,4,2,3};
        int[] val = {10,40,30,50};
        int W = 5;

        int ans = find_ans(wt,val,wt.length-1,W);
        System.out.println(ans);
    }
}
