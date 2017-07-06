public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solutionPair = new int[2]; 
        int arraySize = nums.length; 
        
        for(int i = 0; i < arraySize; i++) {
            for(int j = i+1; j < arraySize; j++){
                if (nums[i] + nums[j] == target){
                    solutionPair[0] = i; 
                    solutionPair[1] = j; 
                    break; 
                }
            }
        }
        return solutionPair;
    }
}