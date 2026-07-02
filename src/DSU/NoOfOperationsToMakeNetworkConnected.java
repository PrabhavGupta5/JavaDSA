package DSU;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// https://www.youtube.com/watch?v=q2xBd-D_1KQ&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=23

// In this question, we have to find the number of components in the graph, because we have to connect all the components together, so the number of operations required will be equal to the number of components - 1, because we can connect two components together in one operation, so if we have 3 components, we need 2 operations to connect them together, if we have 4 components, we need 3 operations to connect them together and so on. So the formula is number of operations = number of components - 1. We can find the number of components using DSU, we will initialize the number of components to n, then for each edge in the connections array, we will check if the two vertices of the edge are in different sets or not, if they are in different sets, then we will union them and decrease the number of components by 1, because we have connected two components together. Finally, we will return the number of components - 1 as the answer.
public class NoOfOperationsToMakeNetworkConnected {
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

    public int makeConnected(int n, int[][] connections) {
        // Need to make all computers connected
        if(connections.length < n - 1)
            return -1;

        DSU dsu = new DSU(n);
        int components = n;

        for(int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            int uParent = dsu.find(u);
            int vParent = dsu.find(v);

            if(uParent != vParent) { // if both have different parents, then it means that they are in different sets, which means that they are not connected, so we will union them and decrease the number of components by 1, because we have connected two components together.
                dsu.unionByRank(u,v);
                components--;
            }
        }

        return components - 1;

    }
}
