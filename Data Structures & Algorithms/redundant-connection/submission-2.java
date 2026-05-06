class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length+1];
        int rank[] = new int[edges.length+1];

        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge:edges){
            if(!union(parent,rank,edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[0];
    }
    private boolean union(int[] par,int[] rank, int u,int v){
        int p1 = findParent(u, par);
        int p2 = findParent(v, par);

        if(p1==p2){
            return false;
        }
        if(rank[p1]>rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    private int findParent(int p,int[] par){
        if(p!=par[p]){
            par[p] = findParent(par[p],par);
        }
        return par[p];
    }
}
