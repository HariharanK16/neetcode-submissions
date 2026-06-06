class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        Set<List<Integer>> res  = new HashSet<>();
        for(int l = 0;l<n-2;l++){
            int m = l + 1, r = n - 1;
            
            while(m<r){
                int sum = nums[l] + nums[m] + nums[r];
                if(sum>0){
                    r--;
                    continue;
                }
                if(sum<0){
                    m++;
                    continue;
                }

                res.add(List.of(nums[l],nums[m],nums[r]));
                r--;
                m++;
            }
        }

        return new ArrayList(res);
    }
}
