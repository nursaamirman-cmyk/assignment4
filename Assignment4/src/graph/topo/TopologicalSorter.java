package graph.topo;

import java.util.*;

public class TopologicalSorter {

    public static List<Integer> sort(Map<Integer, List<Integer>> dag) {
        int n = dag.size();
        int[] indegree = new int[n];

        for (int u : dag.keySet()) {
            for (int v : dag.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : dag.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (order.size() != n) {
            System.out.println("Graph has cycles, topological sort is not possible.");
        }

        return order;
    }
}
