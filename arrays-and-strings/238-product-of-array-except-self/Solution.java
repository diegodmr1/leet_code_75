class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int leftProduct = 1;
        int rightProduct = 1;
        answer[0] = leftProduct;
        leftProduct *= nums[0];

        for (int i = 1; i < length; i++){
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        answer[length - 1] *= rightProduct;
        rightProduct *= nums[length - 1];
        for (int i = length - 2; i >= 0; i--){
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}