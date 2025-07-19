package Dynamic_Programming_Striver;

public class coin_change_recursion {
    public static int find_ans(int[] arr,int index,int target){
//        if(target == 0) return 0;
        if(index == 0){
           if(target%arr[0]==0){
               return target/arr[0];
           }
           else return (int)1e9;
        }

        int pick = (int)1e9;
        if(target>=arr[index]) pick = 1 + find_ans(arr,index,target-arr[index]);
        int not_pick = 0 + find_ans(arr,index-1,target);
        return Math.min(pick,not_pick);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int amount = 11;
        int ans = find_ans(arr,arr.length-1,amount);
        if(ans>=(int)1e9) System.out.println(-1);
        else System.out.println(ans);
    }
}
