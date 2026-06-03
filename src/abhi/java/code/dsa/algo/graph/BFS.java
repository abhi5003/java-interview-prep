package abhi.java.code.dsa.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        System.out.println("Hi there");
    }

    public void bfs(int start, List<List<Integer>> adj){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                System.out.print(cur+" ");

                for(int j:adj.get(cur)){
                    if(!visited[j]){
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }

            // increase level if required
            // level++
        }
    }
}
