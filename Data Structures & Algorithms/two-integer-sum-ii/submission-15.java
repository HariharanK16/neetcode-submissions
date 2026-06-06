class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r= numbers.length - 1;

        while(l<r){
            int left = numbers[l];
            int right = numbers[r];
            if(left + right < target){
                l++;
                continue;
            }
            if(left+right>target){
                r--;
                continue;
            }
            return new int[]{l+1,r+1};
        }
        return new int[]{};

    }
}
