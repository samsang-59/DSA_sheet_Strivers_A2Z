package Dynamic_Programming_Striver;

public class ninja_problem_recursion {

    public static int find_max_points(int index,int PrevTask,int[][] arr){
       if(index==0){
           int max = Integer.MIN_VALUE;
           for(int i=0;i<arr.length;i++){
               if(i!=PrevTask){
                   max = Math.max(max,arr[index][i]);
               }
           }
           return max;
       }

        int max = Integer.MIN_VALUE;
       for(int i=0;i<arr[0].length;i++){
           if(i!=PrevTask){
              int points = arr[index][i] +  find_max_points(index-1,i,arr);
              max = Math.max(max,points);
           }
       }
       return max;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int ans = find_max_points(arr.length-1,-1,arr);
        System.out.println(ans);
    }
}
