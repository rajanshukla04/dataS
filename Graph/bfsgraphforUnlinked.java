package Graph;
import java.util.ArrayList;
import java.util.*;

public class bfsgraphforUnlinked {
    public static class Edge{
        int src;
        int dec;
        Edge(int c,int d){
            this.src=c;
            this.dec=d;
        }
    }
    public static void createGraph(ArrayList<Edge> Graph[]) {
        // replace the null valeue to the Empty list
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 1));
        Graph[0].add(new Edge(0, 2));

        Graph[1].add(new Edge(1, 0));
        //Graph[1].add(new Edge(1, 3));

        Graph[2].add(new Edge(2, 0));
        Graph[2].add(new Edge(2, 4));

        //Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 4));
        Graph[3].add(new Edge(3, 5));

        Graph[4].add(new Edge(4, 2));
        Graph[4].add(new Edge(4, 3));
        //Graph[4].add(new Edge(4, 5));

        Graph[5].add(new Edge(5, 3));
       // Graph[5].add(new Edge(5, 4));
        Graph[5].add(new Edge(5, 6));

        Graph[6].add(new Edge(6, 5));
    }
    public static void Bfs(ArrayList<Edge> Graph[], int V,boolean vis[],int start) {

        Queue<Integer> q = new LinkedList<>();

        // Queue q=new LinkedList<>();
        
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < Graph[curr].size(); i++) {
                    Edge e = Graph[curr].get(i);
                    q.add(e.dec);
                }
            }

        }

    }
    public static void main(String[] args) {
        
        int v=7;
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
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                Bfs(Graph, v, vis, i);
                System.out.println();
            }
        }


    }
}
