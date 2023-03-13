package Graph.pratice;

import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

import javax.swing.plaf.ColorUIResource;

public class bfs {
    public static class Edge {
        int src;
        int dec;

        Edge(int s, int d) {
            this.src = s;
            this.dec = d;
        }
    }

    // write the function to crate the graph
    public static void crate(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 1));
        Graph[0].add(new Edge(0, 2));

        Graph[1].add(new Edge(1, 0));
        Graph[1].add(new Edge(1, 3));

        Graph[2].add(new Edge(2, 0));
        Graph[2].add(new Edge(2, 4));

        Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 4));
        Graph[3].add(new Edge(3, 5));

        Graph[4].add(new Edge(4, 2));
        Graph[4].add(new Edge(4, 3));
        Graph[4].add(new Edge(4, 5));

        Graph[5].add(new Edge(5, 3));
        Graph[5].add(new Edge(5, 4));
        Graph[5].add(new Edge(5, 6));

        Graph[6].add(new Edge(6, 5));

    }

    // BFS in graph
    public static void BFS(ArrayList<Edge> Graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < Graph[curr].size(); i++) {
                    Edge s = Graph[curr].get(i);
                    q.add(s.dec); 
                }
            }

        }

    }

    //DFS 
    public static void DFS(ArrayList<Edge> Graph[],int curr, boolean vis[]){
        System.out.print(curr+" ");
        for(int i=0;i<Graph[curr].size();i++){
            vis[curr]=true;
            Edge s=Graph[curr].get(i);
            if(vis[s.dec]==false){
                DFS(Graph, s.dec, vis);

            }
        }
        // for(int i=0;i<Graph[curr].size();i++){
        //      vis[curr]=true;
        //      Edge e=Graph[curr].get(i);
        //      if(vis[e.dec]==false){
        //         DFS(Graph, e.dec, vis);
        //      }
        // }
    }
    public static void printallPath(ArrayList<Edge> Graph[], boolean vis[], int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (vis[e.dec]==false) {
                vis[curr] = true;
                printallPath(Graph, vis, e.dec, path + e.dec, target);
                vis[curr] = false;

            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
        /*
         * 1-----3
         * / | \
         * 0 | 5----6
         * \ | /
         * 2-----4
         * 
         */

        ArrayList<Edge> Graph[] = new ArrayList[v];
        crate(Graph);
        boolean vis[] = new boolean[v];
        BFS(Graph, vis);
        System.out.println();
        System.out.println("DFS ");
        boolean v2[]=new boolean[v];
       // DFS(Graph, 0, v2);
       System.out.println("helo");
        printallPath(Graph, v2, 0,"0",5);
        System.out.println("done");

    }

}
