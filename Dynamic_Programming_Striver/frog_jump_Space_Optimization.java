package Dynamic_Programming_Striver;

public class frog_jump_Space_Optimization {
    public static int find_Min_Cost(int[] height,int n){
        int prev = 0,prev2 = 0,curri = 0;
        for(int i=1;i<n;i++){
            int left = prev + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = prev2 + Math.abs(height[i] - height[i-2]);
            }
            curri = Math.min(left,right);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] height = {20,30,40,20};
        int ans = find_Min_Cost(height,height.length);
        System.out.println(ans);
    }
}
