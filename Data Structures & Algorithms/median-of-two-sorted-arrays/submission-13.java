class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;

        int total = n+m;
        int half = (total + 1) / 2;

        int l = 0, r = n;
        while(l<=r){
            int mid1 = l + (r-l)/2;
            int mid2 = half - mid1;

            int aLeft = mid1>0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int aRight = mid1<n ? nums1[mid1] :Integer.MAX_VALUE;

            int bLeft = mid2>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int bRight = mid2<m ? nums2[mid2] :Integer.MAX_VALUE;

            if(aLeft<=bRight && bLeft <= aRight){
                if(total%2==0){
                    return (Math.max(aLeft,bLeft) + Math.min(aRight,bRight)) / 2.0;
                }else{
                    return Math.max(aLeft,bLeft);
                }
            } else if(aLeft>bRight) {
                r = mid1 - 1;
            }else{
                l = mid1+1;
            }
        }
        return -1;
    }
}
