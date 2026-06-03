package abhi.java.code.dsa.algo.graph;

import java.util.List;

public class DFSCycle {

    public static void main(String[] args) {

    }

    public boolean undirectedDFSCycle(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if(undirectedDFSCycle(neighbour, node, visited, adj)) return true;
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle(int node, List<List<Integer>> adj){
        boolean[] visited = new boolean[node];
        for (int i = 0; i < node; i++) {

            if (!visited[i]){
               if (undirectedDFSCycle(i, -1, visited, adj))
                   return true;
            }
        }
        return false;
    }
}
