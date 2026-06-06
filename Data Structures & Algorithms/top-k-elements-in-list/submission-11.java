class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int num:nums) count.put(num,count.getOrDefault(num,0)+1);
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int ind = 0;
    
        for(int i = freq.length-1;i>-1 && ind<k;i--){
            for(int n : freq[i]){
                if(ind == k) return result;
                result[ind++] = n;
            }
        }
        return result;
    }
}
