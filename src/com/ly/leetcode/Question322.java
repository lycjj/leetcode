package com.ly.leetcode;

/**
 * 状态转移方程 F(n) = min{F(amount-coins[0]),F(amount-coins[1]),...,F(amount-coins[lenght-1])}
 * @author ly.
 * @date 2021/5/4
 */
public class Question322 {
    public static int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        coinChange(coins,amount,count);
        return count[amount];
    }

    public  static int coinChange(int[] coins, int amount,int[] count) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(count[amount] != 0) {
            return count[amount];
        }
        int result;
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            result = coinChange(coins,amount-coin,count);
            if(result >= 0) {
                min = Math.min(min,result+1);
            }
        }
        count[amount] = min== Integer.MAX_VALUE ? -1 : min;
        return count[amount];
    }

    public static void main(String[] args) {
        int[] coins = {5};
        System.out.println(coinChange(coins,4));
    }
}
