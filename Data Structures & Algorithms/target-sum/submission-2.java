class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer> dp = new HashMap<>();

        dp.put(0,1);

        for(int num: nums){
            Map<Integer,Integer> dp1 = new HashMap<>();
            for(Map.Entry<Integer,Integer> entry: dp.entrySet()){
                int count = entry.getValue();
                int curr_sum  = entry.getKey();
                dp1.put(curr_sum+num, dp1.getOrDefault(curr_sum+num,0)+count);
                dp1.put(curr_sum-num, dp1.getOrDefault(curr_sum-num,0)+count);
            }
            dp = dp1;
        }
        return dp.getOrDefault(target,0);
    }
}

// public class Solution {
//     Map<Pair<Integer,Integer>,Integer> memo;
//     public int findTargetSumWays(int[] nums, int target) {
//         memo = new HashMap<>();
//         return backtrack(0, 0, nums, target);
//     }

//     private int backtrack(int i, int total, int[] nums, int target) {
//         if(memo.containsKey(new Pair<>(i,total))){
//             return memo.get(new Pair<>(i,total));
//         }
//         if (i == nums.length) {
//             return total == target ? 1 : 0;
//         }
//         memo.put(new Pair<>(i,total), backtrack(i + 1, total + nums[i], nums, target) +
//                backtrack(i + 1, total - nums[i], nums, target));
//         return memo.get(new Pair<>(i,total));
//     }
// }