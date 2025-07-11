package Dynamic_Programming_Striver;

import java.util.*;

public class min_sum_path_triangle_memoization {
    public static int find_ans(List<List<Integer>> triangle,int row,int col,List<List<Integer>> dp){
        if(row==triangle.size()-1) {
            return triangle.get(row).get(col);
        }

        if(dp.get(row).get(col)!=-1) return dp.get(row).get(col);

        int down = find_ans(triangle,row+1,col,dp);
        int diagonal = Integer.MAX_VALUE;
        if(col+1 < triangle.get(row+1).size()){
            diagonal = find_ans(triangle,row+1,col+1,dp);
        }

        int result = triangle.get(row).get(col) + Math.min(down,diagonal);
        dp.get(row).set(col,result);
        return dp.get(row).get(col);
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2,3));
        list.add(Arrays.asList(3,6,7));
        list.add(Arrays.asList(8,9,6,10));

        List<List<Integer>> dp = new ArrayList<>();
        for (List<Integer> row : list) {
            List<Integer> dpRow = new ArrayList<>(Collections.nCopies(row.size(), -1));
            dp.add(dpRow);
        }

        int ans = find_ans(list,0,0,dp);
        System.out.println(ans);
    }
}
