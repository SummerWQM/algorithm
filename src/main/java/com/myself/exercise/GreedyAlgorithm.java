package com.myself.exercise;

import java.util.Arrays;

/**
 * 在这个实现中，我们使用了贪心算法来解决一个背包问题。假设我们有一个背包，
 * 它的容量为capacity，同时有n个物品，每个物品有一个重量weight和一个价值value。
 * 我们希望选择一些物品放入背包中，使得背包中物品的总价值最大。
 * <p>
 * 我们首先计算每个物品的价值密度（即单位重量的价值），并按照价值密度从高到低排序。
 * 然后，我们依次选择价值密度最高的物品，直到背包已经装满为止。这样，我们就可以得到一组近似最优解。
 * <p>
 * 总之，贪心算法是一种简单而有效的算法，它可以用于解决很多问题，包括最优化问题、图论问题等。
 * 在实际应用中，需要根据具体问题来选择合适的贪心策略，并注意贪心算法的局限性。
 */

public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5, 6, 7};
        int[] values = {3, 4, 5, 6, 7, 8};
        int capacity = 10;
        int[] result = knapsack(weights, values, capacity);
        System.out.println("The maximum value is: " + result[0]);
        System.out.println("The items included are: " + Arrays.toString(Arrays.copyOfRange(result, 1, result.length)));
    }

    public static int[] knapsack(int[] weights, int[] values, int capacity) {
        int[] result = new int[weights.length + 1];
        int totalValue = 0;
        int remainingCapacity = capacity;

        // Calculate the value per unit of weight for each item
        float[] valuePerUnit = new float[weights.length];
        for (int i = 0; i < weights.length; i++) {
            valuePerUnit[i] = (float) values[i] / (float) weights[i];
        }

        // Sort the items by value per unit of weight in descending order
        for (int i = 0; i < valuePerUnit.length; i++) {
            for (int j = i + 1; j < valuePerUnit.length; j++) {
                if (valuePerUnit[i] < valuePerUnit[j]) {
                    float temp = valuePerUnit[i];
                    valuePerUnit[i] = valuePerUnit[j];
                    valuePerUnit[j] = temp;

                    int tempWeight = weights[i];
                    weights[i] = weights[j];
                    weights[j] = tempWeight;

                    int tempValue = values[i];
                    values[i] = values[j];
                    values[j] = tempValue;
                }
            }
        }

        // Select items greedily based on value per unit of weight
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= remainingCapacity) {
                result[i + 1] = 1;
                totalValue += values[i];
                remainingCapacity -= weights[i];
            }
        }

        result[0] = totalValue;
        return result;
    }
}