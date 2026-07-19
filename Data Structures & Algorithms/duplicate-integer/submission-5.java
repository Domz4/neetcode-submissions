class Solution {

    // OPTIMAL SOLUTION
    // public boolean hasDuplicate(int[] nums) {
    //     // for sorted array we could use simple two pointer tehnique and for non sorted hashmap
    //     // I'll do the second one 

    //     Map<Integer, Integer> dups = new HashMap<>();
        
    //     for (int i=0;i<nums.length ; i++) {   
    //         if(!dups.containsKey(nums[i])) {
    //             dups.put(nums[i], 1);
    //         } else {return true;}
    //     }

    //     return false;
    // }

    public boolean hasDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


}