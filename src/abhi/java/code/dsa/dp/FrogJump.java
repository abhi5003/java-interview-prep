package abhi.java.code.dsa.dp;

import java.util.Arrays;

public class FrogJump {
    static int[] dp;
    public static void main(String[] args) {

        int[] h={10, 20, 30, 10};
        System.out.println(frogJump(h));
    }

    public static int frogJump(int[] h){
        int n= h.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n -1, h);
    }

    private static int solve(int i, int[] h) {

        if(i==0) return 0;
        if(i==1) return Math.abs(h[1] - h[0]);
        if(dp[i]!= -1) return dp[i];

        int oneStep = solve(i -1, h) + Math.abs(h[i] - h[i - 1]);
        int twoStep = solve(i - 2, h) + Math.abs(h[i] - h[i - 2]);

        dp[i] = Math.min(oneStep, twoStep);

        return dp[i];
    }
}
