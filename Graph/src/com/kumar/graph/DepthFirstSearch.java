package com.kumar.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class DepthFirstSearch {
    public static void DFS(int node, List<Integer>[] G, List<Integer> used, List<Integer> parent) {
        System.out.println(node);
        used.set(node, 1);
 
        for (int u : G[node]) {
            if (used.get(u) == 0) {
                parent.set(u, node);
                DFS(u, G, used, parent);
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Enter number of nodes of a graph:");
        int n = scanner.nextInt();
        System.out.println("Enter number of edges of a graph:");
        int m = scanner.nextInt();
        List<Integer>[] G = new List[n + 5];
        for (int i = 0; i < n + 5; i++) {
            G[i] = new ArrayList<>();
        }
 
        int i = 1;
        while (i <= m) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            G[u].add(v);
            G[v].add(u);
            i++;
        }
 
        List<Integer> used = new ArrayList<>(n + 5);
        List<Integer> parent = new ArrayList<>(n + 5);
        for (int j = 0; j < n + 5; j++) {
            used.add(0);
            parent.add(0);
        }
 
        DFS(1, G, used, parent);
    }
}

//Input:
//Enter number of nodes of a graph:
//8
//Enter number of edges of a graph:
//7
//1 2
//1 3
//2 4 
//2 5 
//3 6 
//3 7 
//5 8

//Output:
//1
//2
//4
//5
//8
//3
//6
//7