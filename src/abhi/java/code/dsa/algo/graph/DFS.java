package abhi.java.code.dsa.algo.graph;

import java.util.List;

public class DFS {

    public static void main(String[] args) {

    }

    public void startDfs(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i, visited, adj);
            }
        }
    }
    public void dfs(int node, boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        System.out.println(node); // or do something

        for(int neighbour : adj.get(node)){
            if (!visited[neighbour]){
                dfs(neighbour, visited, adj);
            }
        }
    }
}
