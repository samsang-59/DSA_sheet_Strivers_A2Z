package Dynamic_Programming_Striver;

public class frog_jump_recursion {
    public static int find_Min_Cost(int[] height,int index){
        if(index==0){
            return 0;
        }

        int left = find_Min_Cost(height, index-1) + Math.abs(height[index] - height[index-1]);
        int right = Integer.MAX_VALUE;
        if(index>1){
            right = find_Min_Cost(height,index-2) + Math.abs(height[index] - height[index-2]);
        }

        return Math.min(left,right);
    }
    public static void main(String[] args) {
        int[] height = {20,30,40,20};
        int ans = find_Min_Cost(height,height.length-1);
        System.out.println(ans);
    }
}
