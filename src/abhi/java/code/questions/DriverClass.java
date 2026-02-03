package abhi.java.code.questions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DriverClass {

    public static void main(String[] args) {

        int[] stalls ={1, 2, 4, 8, 9};
        int k=3;
        int res = aggressiveCows(stalls, k);
        System.out.println(res);

    }

    private static int[] twoSum(int[] arr, int target){
        int left=0;
        int right= arr.length -1;
        Arrays.sort(arr);

        while(left<right){
            int sum=arr[left] + arr[right];

            if (target == sum) return new int[] {left, right};
            else if(target > sum) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }


    public boolean isPalindrome(String s){
        if(s==null) return true;
        String res="";

        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                res+=c=Character.toLowerCase(c);
            }
        }
        return checkPal(res);
    }

    private boolean checkPal(String str){
        int l=0;
        int r=str.length()-1;

        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome2(String str){
        if(str==null) return true;

        String collect = str.chars().filter(Character::isLetterOrDigit)
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return IntStream.range(0, collect.length()/2)
                .allMatch(i->collect.charAt(i)==collect.charAt(collect.length()-1 - i));
    }


    // sliding window pattern
    public int maxSumSubArray(int[] arr, int k){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        // adding first window sum
        for (int i = 0; i < k; i++) {
            currSum+=arr[i];
        }

        maxSum=Math.max(currSum, maxSum);

        for (int i = k; i < arr.length; i++) {
            currSum+=arr[i] - arr[i - k];
            maxSum=Math.max(currSum, maxSum);
        }

        return maxSum;
    }


    public int lengthOfLongestSubstring(String str){
        int len=str.length();
        if (len<=0) return 0;
        int maxLen=1;
        int left=0;
        Map<Character, Integer> map=new HashMap<>();

        for (int right = 0; right < len; right++) {
            if (map.containsKey(str.charAt(right))){
                left=Math.max(map.get(str.charAt(right)) + 1, left);
            }

            maxLen=Math.max(maxLen, right - left + 1);
            map.put(str.charAt(right), right);
        }
        return maxLen;
    }

    public int[][] mergeInterval(int[][] intervals){

        List<int[]> res=new ArrayList<>();

        // first sort the intervals by there starting point
        Arrays.sort(intervals, (arr1, arr2)->arr1[0] - arr2[0]);

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int[] interval : intervals){

            if(interval[0]<=end){
                end=Math.max(interval[1], end);
            }
            else {
            res.add(new int[]{start, end});
            start=interval[0];
            end=interval[1];
        }


    }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }

    public static int aggressiveCows(int[] stalls, int k){

        int minDist=1;
        int maxDist=stalls[stalls.length - 1] - stalls[0];
        int res=0;

        while (minDist<=maxDist){
            int mid= minDist + (maxDist - minDist)/2;
            if(check(stalls, mid, k)){
                res=mid;
                minDist=mid + 1;
            }else {
                maxDist = mid - 1;
            }

        }
        return res;
    }

    public static boolean check(int[] stalls, int dist, int k){
        int cnt=1;
        int prev=stalls[0];

        for (int i = 1; i <stalls.length ; i++) {
            if(stalls[i] - prev>=dist){
                prev=stalls[i];
                cnt++;
            }
        }

        return (cnt>=k);
    }

}


