class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        // 

        for (int num : nums) {
            if(uf.root.containsKey(num + 1)){
                uf.union(num, num+1);
            }
        }
        

        return uf.maxSize;
    }
}


class UnionFind {
        public Map<Integer, Integer> root = new HashMap<>();
        private Map<Integer, Integer> groupsSize = new HashMap<>();
        public int maxSize = 0;
    
        public UnionFind(int[] nums) {
            for(int num : nums) {
                if (!root.containsKey(num)) {
                    root.put(num, num);
                    groupsSize.put(num, 1);
                }
            }
            if (root.size() > 0) maxSize = 1;
        }

        public int find(int x) {
            if (x == root.get(x)) {
                return x;
            }
            int newRoot = find(root.get(x));
            root.put(x, newRoot);
            return newRoot;
        }

        public boolean union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty) {
                if (groupsSize.get(rootx) > groupsSize.get(rooty)) {
                    root.put(rooty, rootx); 
                    groupsSize.put(rootx, groupsSize.get(rootx) + groupsSize.get(rooty));

                    maxSize = Math.max(maxSize, groupsSize.get(rootx)); 
                } else {
                    root.put(rootx, rooty); // podpinamy X pod Y
                    groupsSize.put(rooty, groupsSize.get(rooty) + groupsSize.get(rootx));

                    maxSize = Math.max(maxSize, groupsSize.get(rooty));
                }
                return true;
            }
            return false;
        }
}