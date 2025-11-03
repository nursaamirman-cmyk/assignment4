package graph.scc;

import java.util.*;

public class SCCFinder {

    private final Map<Integer, List<int[]>> graph;
    private int time = 0;
    private final int[] disc;
    private final int[] low;
    private final boolean[] onStack;
    private final Stack<Integer> stack;
    private final List<List<Integer>> sccList;

    public SCCFinder(Map<Integer, List<int[]>> graph) {
        this.graph = graph;
        int n = graph.size();
        disc = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();
        sccList = new ArrayList<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
    }

    public List<List<Integer>> findSCCs() {
        for (int v : graph.keySet()) {
            if (disc[v] == -1) {
                dfs(v);
            }
        }
        return sccList;
    }

    private void dfs(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        onStack[u] = true;

        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                int v = stack.pop();
                onStack[v] = false;
                component.add(v);
                if (v == u) break;
            }
            sccList.add(component);
        }
    }

public Map<Integer, List<Integer>> buildCondensationGraph() {
    Map<Integer, Integer> compIndex = new HashMap<>();
    for (int i = 0; i < sccList.size(); i++) {
        for (int v : sccList.get(i)) {
            compIndex.put(v, i);
        }
    }

    Map<Integer, List<Integer>> dag = new HashMap<>();
    for (int i = 0; i < sccList.size(); i++) {
        dag.put(i, new ArrayList<>());
    }

    for (int u : graph.keySet()) {
        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            int cu = compIndex.get(u);
            int cv = compIndex.get(v);
            if (cu != cv && !dag.get(cu).contains(cv)) {
                dag.get(cu).add(cv);
            }
        }
    }

    return dag;
}
}

