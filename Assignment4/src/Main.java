

import graph.scc.SCCFinder;
import graph.topo.TopologicalSorter;
import src.GraphLoader;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart City / Smart Campus Scheduling ===");

        Map<Integer, List<int[]>> graph = GraphLoader.loadGraph("data/tasks.json");
        if (graph.isEmpty()) {
            System.out.println("Graph is empty. Please check your JSON file.");
            return;
        }

        System.out.println("\n--- Strongly Connected Components ---");
        SCCFinder sccFinder = new SCCFinder(graph);
        List<List<Integer>> sccs = sccFinder.findSCCs();

        int index = 1;
        for (List<Integer> comp : sccs) {
            System.out.println("SCC " + index + ": " + comp);
            index++;
        }
        System.out.println("Total components: " + sccs.size());

        System.out.println("\n--- Condensation DAG ---");
        Map<Integer, List<Integer>> dag = sccFinder.buildCondensationGraph();
        for (int u : dag.keySet()) {
            System.out.println(u + " -> " + dag.get(u));
        }

        System.out.println("\n--- Topological Order ---");
        List<Integer> topoOrder = TopologicalSorter.sort(dag);
        System.out.println("Order: " + topoOrder);
    }
}
