package main.java;

/**
 * Created by dianwen on 6/4/15.
 */
public class LeastNumberOfCoins {
    public static int findLeastNumberOfCoins(int sum, int[] coins) {
        int[] minCoinsToSums = new int[sum + 1];

        for(int i = 1; i < minCoinsToSums.length; i++) {
            minCoinsToSums[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(coin <= i) {
                    minCoinsToSums[i] = Math.min(minCoinsToSums[i - coin] + 1, minCoinsToSums[i]);
                }
            }
        }

        return minCoinsToSums[sum];
    }
}
