package Dynamic_Programming_Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class min_sum_path_triangle_tabular {
    public static int find_ans(List<List<Integer>> list,List<List<Integer>> dp){
        int n = list.size();
        for(int col=0;col<list.get(n-1).size();col++){
            dp.get(n-1).set(col,list.get(n-1).get(col));
        }

        for(int row=n-2;row>=0;row--){
            for(int col=0;col<list.get(row).size();col++){
                int down = dp.get(row+1).get(col);
                int diagonal = dp.get(row+1).get(col+1);
                int result = list.get(row).get(col) + Math.min(down,diagonal);
                dp.get(row).set(col,result);
            }
        }
        return dp.get(0).get(0);
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
        int ans = find_ans(list,dp);
        System.out.println(ans);
    }
}
