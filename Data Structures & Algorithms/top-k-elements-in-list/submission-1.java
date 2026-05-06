class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i],value+1);
            }else{
                map.put(nums[i],1);
            }
        }

        ArrayList<List<Integer>> arr=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            arr.get(entry.getValue()-1).add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        int i=n-1;
        while(k>0 && i>=0){
            List<Integer> mid = arr.get(i);
            int m = mid.size();
            if(m>0){
                while(m>0&&k>0){
                res.add(mid.get(m-1));
                m--;
                k--;
                }
                System.out.println(mid);

            }
            i--;
        }
        System.out.println(map);
        System.out.println(arr);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
