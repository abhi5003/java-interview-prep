package abhi.java.code.questions;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr={10, 5, 11, 7, 2, 4, 3, 12};
        int target=10;

        System.out.println(Arrays.toString(two_sum(arr, target)));

    }

    private static int[] two_sum(int[] arr, int target){

        Arrays.sort(arr);
        int n= arr.length;

        int left=0;
        int right= n- 1;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(sum==target){
                return new int[]{left, right};
            } else if (sum < target) {
                // sum+=arr[left];
                left++;
            }else{
               // sum-=arr[right];
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}


// User, Comment

/*
  <<User>>          ->doCommonent (user_id, edit, commetId){


  }
                   -> getAllComment
                   -> getCommentByID
   id;
   name;
   List<Comment>


   <<Comment>>
     id,
     User



 */
