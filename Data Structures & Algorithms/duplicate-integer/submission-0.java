class Solution {
    public boolean hasDuplicate(int[] nums) {
        // for sorted array we could use simple two pointer tehnique and for non sorted hashmap
        // I'll do the second one 

        Map<Integer, Integer> dups = new HashMap<>();

        boolean flag = false;
        
        for (int i=0;i<nums.length ; i++) {   
            if(dups.containsKey(nums[i])) {
                flag = true;
                break;
            }
            dups.put(nums[i], 1);
        }

        return flag;
    }
}