package DSU;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
// https://www.youtube.com/watch?v=0Z8lt7U_kiE&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=21

public class EqualityEquations {
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

    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);

        // Process all ==
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a'; // we are converting the character to an index, because we have 26 lowercase letters, so we can use an array of size 26 to represent the parent and rank of each character. For example, 'a' will be represented by index 0, 'b' by index 1, and so on.
                int v = eq.charAt(3) - 'a';

                dsu.unionByRank(u, v);
            }
        }

        // Process all !=
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if (dsu.find(u) == dsu.find(v)) // comparing the parents of u and v, if they are same, then it means that u and v are in the same set, which means that they are equal, but we have a != equation, which means that they should not be equal, so we will return false.
                    return false;
            }
        }

        return true;
    }

}
