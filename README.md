# Assignment 4 — Graph Algorithms for Task Scheduling

**Author:** Nursa Mirman  
**Course:** Design and Analysis of Algorithms  
**Year:** 2025



## Overview
This project implements several graph algorithms for analyzing dependencies between tasks in a Smart City / Smart Campus Scheduling system.  
The input is a directed weighted graph in JSON format (`tasks.json`), representing tasks and their dependencies.



## Implemented Modules

### 1. Graph Loading
- Implemented using the Gson library.  
- Parses JSON data and builds an adjacency list representation of a directed weighted graph.

### 2. Strongly Connected Components (SCC)
- Implemented Tarjan’s Algorithm.  
- Detects all strongly connected components within the directed graph.

### 3. Condensation DAG and Topological Sorting
- Builds a condensation graph (DAG) where each SCC is represented as a single node.  
- Performs topological sorting using Kahn’s Algorithm.

### 4. Shortest and Longest Paths in DAG
- Implements dynamic programming algorithms to find the shortest and longest paths in a DAG using the topological order.


## Code Structure
src/
├── GraphLoader.java
├── Main.java
└── graph/
├── scc/
│ └── SCCFinder.java
├── topo/
│ └── TopologicalSorter.java
└── paths/
└── DAGShortestPaths.java

---

## Reflections
Through this project, I learned:
- How directed graphs can represent task dependencies.  
- How to detect and handle strongly connected components using Tarjan’s algorithm.  
- How to build a condensation DAG and apply topological sorting.  
- How to efficiently find shortest and longest paths in acyclic graphs.

---

## Conclusion
The project demonstrates the use of graph algorithms in real-world scheduling and dependency analysis problems.  
All required functionalities — SCC detection, condensation DAG construction, topological sorting, and shortest/longest path computation — have been implemented and verified successfully.


