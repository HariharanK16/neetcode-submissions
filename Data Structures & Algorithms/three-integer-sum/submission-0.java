class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                    continue;
                }
                if(sum>0){
                    k--;
                    continue;
                }
                List<Integer> ls = new ArrayList<Integer>();
                ls.add(nums[i]);
                ls.add(nums[j]);
                ls.add(nums[k]);
                set.add(ls);
                j++;
                k--;
            }
        }
        for(List<Integer> l : set){
            list.add(l);
        }
        return list;
    }
}
