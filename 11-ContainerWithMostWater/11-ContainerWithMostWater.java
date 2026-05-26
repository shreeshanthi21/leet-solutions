// Last updated: 5/26/2026, 12:34:51 PM
class Solution {
    public int maxArea(int[] height) {
        int maxi=0;
        int left=0; int right=height.length-1;
        int area;
        int prev_area=0;
        while(left<right){
            area=(right-left)*Math.min(height[left],height[right]);
            if(height[left]<=height[right]) left++;
            else if (height[left]>height[right]) right--;
            if(maxi<area) maxi=area;
            prev_area=area;
        }
        return maxi;
    }
}