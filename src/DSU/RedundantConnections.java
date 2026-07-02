package DSU;

// https://leetcode.com/problems/redundant-connection/

public class RedundantConnections {

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]); // Path Compression
        }

        public void unionByRank(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV)
                return; // if both have same parent, then they are already in the same set, so we don't need to do anything.

            if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            } else if (rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;
            } else {
                parent[parentV] = parentU;
                rank[parentU]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        DSU dsu = new DSU(edges.length + 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) == dsu.find(v))
                return edge;

            dsu.unionByRank(u, v);

        }

        return new int[]{};
    }

}
