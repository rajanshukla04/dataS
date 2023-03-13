package Graph;

import java.util.*;;

public class DFS {
    // carete the vertix
    public static class Edge {
        int src;
        int dec;

        Edge(int s, int d) {
            this.src = s;
            this.dec = d;
        }
    }

    // create the graph
    public static void createGraph(ArrayList<Edge> Graph[]) {
        // replace the null valeue to the Empty list
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

    // public static void Dfs(ArrayList<Edge> Grahp[], int curr, boolean vis[]) {
    //     System.out.print(curr + " ");
    //     for (int i = 0; i < Grahp[curr].size(); i++) {
    //         vis[curr] = true;
    //         Edge e = Grahp[curr].get(i);

    //         if (vis[e.dec] == false) {
    //             Dfs(Grahp, e.dec, vis);
    //         }
    //     }
    // }

    // printallPath form source to target
    public static void printallPath(ArrayList<Edge> Graph[], boolean vis[], int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < Graph[curr].size(); i++) {
            Edge e = Graph[curr].get(i);
            if (!vis[e.dec]) {
                vis[curr] = true;
                printallPath(Graph, vis, e.dec, path + e.dec, target);
                vis[curr] = false;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("HELLO RAJAN");
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
        createGraph(Graph);
        System.out.println("hello ");
        boolean vis[] = new boolean[v];
        int src = 0, target = 5;
        printallPath(Graph, vis, src, "0", target);

    }

}
