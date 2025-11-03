package src;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.util.*;

public class GraphLoader {

    public static Map<Integer, List<int[]>> loadGraph(String path) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        try (FileReader reader = new FileReader(path)) {
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(reader, JsonObject.class);

            int n = json.get("n").getAsInt();
            JsonArray edges = json.getAsJsonArray("edges");

            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < edges.size(); i++) {
                JsonObject edge = edges.get(i).getAsJsonObject();
                int u = edge.get("u").getAsInt();
                int v = edge.get("v").getAsInt();
                int w = edge.get("w").getAsInt();

                graph.get(u).add(new int[]{v, w});
            }

            System.out.println("✅ Graph loaded successfully: " + n + " vertices, " + edges.size() + " edges.");
        } catch (Exception e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }

        return graph;
    }
}

