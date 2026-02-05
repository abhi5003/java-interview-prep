package abhi.java.code.dsa.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrqEle {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,1,2,3,1,3,2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrqElement1(nums, k)));
    }

    private static int[] topKFrqElement(int[] nums, int k){
        int[] res = new int[k];
        List<Integer> collect = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> Math.toIntExact(o2.getValue() - o1.getValue()))
                .limit(k).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            res[i] = collect.get(i);
        }
        return res;
    }

    private static int[] topKFrqElement1(int[] nums, int k){
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // min heap which sorting value of map in ascending order
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        map.keySet().forEach(num -> {
            minPQ.add(num);
            if (minPQ.size() > k) minPQ.poll();
        });

        for (int i =k - 1; i >=0; i--) {
            res[i] = minPQ.poll();
        }
        return res;
    }
}
