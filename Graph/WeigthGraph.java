package Graph;

import java.util.ArrayList;

public class WeigthGraph {
    public static class Edge{
        int src;
        int dec;
        int weight;
        Edge(int s,int d,int w){
            this.src=s;
            this.dec=d;
            this.weight=w;
        
        }

    }

    //Create the graph in  the tree
    public static void crate(ArrayList<Edge> Graph[]){
        // array has null value we just replace the value with the Empty list 
        
        for(int i=0;i<Graph.length;i++){
            Graph[i]=new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 2, 2));
        Graph[1].add(new Edge(1, 2, 10));
        Graph[1].add(new Edge(1,3, 0));
        
        Graph[2].add(new Edge(2, 0, 2));
        Graph[2].add(new Edge(2, 3,-1));
        Graph[2].add(new Edge(2, 1, 10));

        Graph[3].add(new Edge(3,1, 0));
        Graph[3].add(new Edge(3,2, -1));


    }

    public static void main(String[] args) {
        int v=4;
        ArrayList <Edge> Graph[]=new ArrayList[v];

        crate(Graph);
        System.out.println("print the neighbour of 2");
        for(int i=0;i<Graph[2].size();i++){
            Edge e=Graph[2].get(i);
            System.out.println(e.src+" "+e.dec+" "+e.weight+" ");
        }
    
}
}