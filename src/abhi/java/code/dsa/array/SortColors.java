package abhi.java.code.dsa.array;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
       int[] nums = new int[]{2,0,1};
       sortCol(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortCol(int[] nums){
        int[] colArr = new int[3];
        for (int num : nums){
            colArr[num]++;
        }
        int idx=0;
        for(int i=0; i<3; i++){
            while (colArr[i]-- > 0){
                nums[idx++] = i;
            }
        }
    }
}
