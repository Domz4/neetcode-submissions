class Solution {
    public int maxArea(int[] heights) {
        int l = 0,r = heights.length - 1;
        int width = r - l;
        int height = Math.min(heights[l], heights[r]);
        int max = width * height;
        while(l<r) {
            height = Math.min(heights[l], heights[r]);
            width = r - l;
            max = Math.max(max, height * width);
            if(heights[l] > heights[r]) {
                r--;    
            } else {
                l++;
            }
        }
        return max;
    }
}
