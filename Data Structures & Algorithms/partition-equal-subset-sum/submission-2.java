public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target =  sum / 2;

        for (int i = nums.length - 1; i > -1; i--) {
            Set<Integer> nextDP = new HashSet<>(dp);
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDP.add(t + nums[i]);
                // nextDP.add(t);
            }
            dp = nextDP;
        }
        return false;
    }
}