class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> ints = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            ints.merge(nums[i],1,Integer::sum);
        }

        return ints.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
