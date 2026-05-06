class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;

        int totalCost = 0;
        int currCost = 0;

        for(int i = 0;i<n;i++){
            totalCost +=  gas[i] - cost[i];
            currCost +=  gas[i] - cost[i];

            if(currCost<0){
                currCost = 0;
                start = i + 1;
            }

        }

        return totalCost<0 ? -1 : start;
    }
}
