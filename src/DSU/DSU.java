package DSU;

// https://youtu.be/iH3XVIVzl7M?si=a9FD_cVbpa2xiBlI
public class DSU {
    // Disjoint Set Union (DSU) or Union-Find is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. It provides two main operations: find and union.
    int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int i, int[] parent) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent); // path compression
    }

    // union by size
    private void union(int[] parent, int u, int v) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU != parentV) {
            parent[parentU] = parentV; // Union, ParentV becomes the parent of ParentU
        }
    }

    // union by rank
    public void unionByRank(int u, int v) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU == parentV)
            return; // if both have same parent, then they are already in the same set, so we don't need to do anything.

        // we will attach the smaller rank tree under the root of the higher rank tree, because we want to keep the tree as flat as possible, so that the find operation can be performed in O(1) time.
        // more rank will be the parent. If both have same rank, then we can make any one as parent and increase its rank by 1.
        if(rank[parentV] > rank[parentU]) {
            parent[parentU] = parentV; // Parent of parentU will be parentV, because parentV has higher rank
        } else if(rank[parentV] < rank[parentU]) {
            parent[parentV] = parentU;
        } else { // both have same rank
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }

}
