package com.myself.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadBalance {
    public static void main(String[] args) {
        List<Node> nodes = Arrays.asList(new Node("a", 4), new Node("b", 2), new Node("c", 1));

        for (int i = 1; i < 8; i++) {
            System.out.println(roundLoadBalance(nodes, i));
        }
    }


    public static String roundLoadBalance(List<Node> nodes, int current) {
        int sumWeight = 0;

        final LinkedHashMap<String, IntegerWrapper> invokerToWeightMap = new LinkedHashMap<>();

        for (Node node : nodes) {
            invokerToWeightMap.put(node.getKey(), new IntegerWrapper(node.getWeight()));
            sumWeight += node.getWeight();
        }

        int mod = current % sumWeight;

        for (int i = 0; i < 4; i++) {


            for (Map.Entry<String, IntegerWrapper> each : invokerToWeightMap.entrySet()) {

                String k = each.getKey();
                final IntegerWrapper v = each.getValue();
                if (mod == 0 && v.getValue() > 0) {
                    return k;
                }
                if (v.getValue() > 0) {
                    v.decrement();
                    mod--;
                }
            }
        }

        return nodes.get(current % nodes.size()).getKey();

    }


    static class Node {
        String key;

        Integer weight;

        Node(String k, Integer w) {
            key = k;
            this.weight = w;
        }

        public String getKey() {
            return key;
        }

        public Integer getWeight() {
            return weight;
        }


    }

    private static final class IntegerWrapper {
        private int value;

        public IntegerWrapper(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void decrement() {
            this.value--;
        }
    }
}
