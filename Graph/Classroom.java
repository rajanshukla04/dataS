package Graph;

import java.util.ArrayList;
public class Classroom {
    public static class Edge{
        int src;
        int dec;
        public Edge(int s,int d){
            this.src=s;
            this.dec=d;
        }
    }

    public static void createGraph(ArrayList<Edge> Graph[]){
        // as our array is null then i have to swith to then as Empty list 
        // we can add the value in the null 
        // we have to crate the Empty list to sotre the graph edge 
        for(int i=0;i<Graph.length;i++){
            Graph[i]=new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 2));
        Graph[0].add(new Edge(1, 2));

        // graph 
        Graph[1].add(new Edge(1, 2));
        Graph[1].add(new Edge(1, 3));

        Graph[2].add(new Edge(2, 0));
        Graph[2].add(new Edge(2, 1));

        Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 2));


    }
    public static void main(String[] args) {
        int v=4;  // here we give as numbe of vertices in the graph 
        // Carete the array of arralist to  
        ArrayList<Edge> Graph[]=new ArrayList[v];
        createGraph(Graph);
        System.out.println();
        // print the nebhgours of 2
        for(int i=0;i<Graph[2].size();i++){
            Edge r=Graph[2].get(i);
            System.out.println(r.dec+" ");
            
        }
        

    }
    
}
