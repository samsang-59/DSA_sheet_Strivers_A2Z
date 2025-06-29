package Strivers_A2Z_DSA.Recursion;

public class fibonacci {
    public static int find_ans(int n){
        if(n<=1) return n;
        return find_ans(n-1) + find_ans(n-2);
    }
    public static void main(String[] args) {
        int n = 3;
        int ans = find_ans(n);
        System.out.println(ans);
    }
}
