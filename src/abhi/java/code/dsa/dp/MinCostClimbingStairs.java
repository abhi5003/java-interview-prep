package abhi.java.code.dsa.dp;

public class MinCostClimbingStairs {

    static int[] dp;
    public static void main(String[] args) {
       int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost){
        int n=cost.length;
        dp = new int[n];
        return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
    }

    private static int minCost(int n, int[] cost) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        if(dp[n] !=0) return dp[n];
        return dp[n] = cost[n] + Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
    }
}
