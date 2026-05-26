// Last updated: 5/26/2026, 12:35:00 PM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int low = 0;
        int high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (total + 1) / 2 - i;

            int Aleft;
            if (i == 0) {
                Aleft = Integer.MIN_VALUE;
            } else {
                Aleft = nums1[i - 1];
            }

            int Aright;
            if (i == m) {
                Aright = Integer.MAX_VALUE;
            } else {
                Aright = nums1[i];
            }

            int Bleft;
            if (j == 0) {
                Bleft = Integer.MIN_VALUE;
            } else {
                Bleft = nums2[j - 1];
            }

            int Bright;
            if (j == n) {
                Bright = Integer.MAX_VALUE;
            } else {
                Bright = nums2[j];
            }

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 0) {
                    int maxLeft = Math.max(Aleft, Bleft);
                    int minRight = Math.min(Aright, Bright);
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return (double)Math.max(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
    return 0.00;
        
    }
}
