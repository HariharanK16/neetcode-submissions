class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0 , j = 0;
        int[] res = new int[n+m];
        int ind = 0;
        while(true){
            if(i>=n || j>=m){
                break;
            }
            if(nums1[i]<nums2[j]){
                res[ind++] = nums1[i++];
            } else{
                res[ind++] = nums2[j++];
            }
        }
        while(i<n){
            res[ind++] = nums1[i++];
        }
        while(j<m){
            res[ind++] = nums2[j++];
        }

        int mid  = (n+m)/2;
        if((n+m)%2 == 0){
            return (double)(res[mid]+res[mid-1])/2;
        } else {
            return res[mid];
        }
    }
}
