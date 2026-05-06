public class Solution {
    Map<Pair<Integer,Integer>,Integer> memo= new HashMap<>();;
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if(memo.containsKey(new Pair<>(i,total))){
            return memo.get(new Pair<>(i,total));
        }
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        memo.put(new Pair<>(i,total), backtrack(i + 1, total + nums[i], nums, target) +
               backtrack(i + 1, total - nums[i], nums, target));
        return memo.get(new Pair<>(i,total));
    }
}