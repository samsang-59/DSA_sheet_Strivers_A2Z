package Dynamic_Programming_Striver;

public class Staircase_Problem {
    public static int count_ways(int n){
        if (n==0 || n==1) return 1;
        int left = count_ways(n-1);
        int right = count_ways(n-2);
        return left + right ;
    }
    public static void main(String[] args) {
        int n = 3;
        int ans = count_ways(n);
        System.out.println(ans);
    }
}
