class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> ints = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            ints.merge(nums[i],1,Integer::sum);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        for (Map.Entry<Integer, Integer> entry : ints.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return IntStream.generate(() -> minHeap.poll()[0])
                .limit(k)
                .toArray();
    }
}


//         return ints.entrySet().stream()
//         .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//         .limit(k)
//         .mapToInt(Map.Entry::getKey)
//         .toArray();