package graph.paths;

import java.util.*;

public class DAGShortestPaths {

    public static Map<Integer, Integer> shortestPaths(Map<Integer, List<int[]>> graph, List<Integer> topoOrder, int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        for (int u : topoOrder) {
            if (dist.get(u) != Integer.MAX_VALUE) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (dist.get(v) > dist.get(u) + w) {
                        dist.put(v, dist.get(u) + w);
                    }
                }
            }
        }

        return dist;
    }

    public static Map<Integer, Integer> longestPaths(Map<Integer, List<int[]>> graph, List<Integer> topoOrder, int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : graph.keySet()) {
            dist.put(node, Integer.MIN_VALUE);
        }
        dist.put(start, 0);

        for (int u : topoOrder) {
            if (dist.get(u) != Integer.MIN_VALUE) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (dist.get(v) < dist.get(u) + w) {
                        dist.put(v, dist.get(u) + w);
                    }
                }
            }
        }

        return dist;
    }
}
