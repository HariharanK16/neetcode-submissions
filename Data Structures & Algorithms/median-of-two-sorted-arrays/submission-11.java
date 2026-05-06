class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        int half = (total+1) / 2;
        int l = 0, r = n;
        while(l<=r){
            int mid = l + (r - l) / 2;
            int mid2 = half - mid;

            int aleft = (mid)>0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int aright = mid<n ? nums1[mid] : Integer.MAX_VALUE;

            int bleft = (mid2)>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int bright = mid2<m ? nums2[mid2] : Integer.MAX_VALUE;

            if(aleft<=bright && aright>=bleft){
                if(total%2==0){
                    return (Math.max(aleft,bleft) + Math.min(aright,bright)) / 2.0;
                }else{
                    return Math.max(aleft,bleft);
                }
            }
            if(aleft>bright){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
