class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        int half = (total + 1)/2;
        int l = 0 , r = n;
        while(l<=r){
            int m1 = l + (r - l)/2;
            int m2 = half - m1;

            int aLeft = m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
            int aRight = m1 >= n ? Integer.MAX_VALUE : nums1[m1];
            int bLeft = m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
            int bRight = m2 >= m ? Integer.MAX_VALUE : nums2[m2];

            if(aLeft <= bRight && aRight>=bLeft){
                if(total % 2 == 0){
                    return (Math.max(aLeft,bLeft) + Math.min(aRight,bRight)) / 2.0;
                }else {
                    return Math.max(aLeft,bLeft);
                }
            }
            if(aLeft > bRight){
                r = m1 - 1;
            }else{
                l = m1 + 1;
            }
        }
        return -1;
    }
}
