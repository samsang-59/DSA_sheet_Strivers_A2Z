package Dynamic_Programming_Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class min_sum_path_triangle {
    public static int find_ans(List<List<Integer>> triangle,int row,int col){
        if(row==triangle.size()-1) {
            return triangle.get(row).get(col);
        }
        int down = find_ans(triangle,row+1,col);
        int diagonal = Integer.MAX_VALUE;
        if(col+1 < triangle.get(row+1).size()){
            diagonal = find_ans(triangle,row+1,col+1);
        }
        return triangle.get(row).get(col) + Math.min(down,diagonal);
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2,3));
        list.add(Arrays.asList(3,6,7));
        list.add(Arrays.asList(8,9,6,10));

        int ans = find_ans(list,0,0);
        System.out.println(ans);

    }
}
