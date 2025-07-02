package Dynamic_Programming_Striver;

public class frog_jump_K_Steps_Recursion {
    public static int find_ans(int[] height,int index,int k){

        if(index==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            int jump_Energy = 0;
            if(index>=i){
                jump_Energy = find_ans(height,index-i,k) + Math.abs(height[index] - height[index-i]);
            }
            min = Math.min(jump_Energy,min);
        }

        return min;
    }
    public static void main(String[] args) {
        int[] height = {10, 5, 20, 0, 15};
        int ans = find_ans(height,height.length-1,2);
        System.out.println(ans);
    }
}
